package br.com.peoplemanagement.impl;

import br.com.peoplemanagement.commons.enums.IdentifierTypeEnum;
import br.com.peoplemanagement.commons.exceptions.ExceptionUtils;
import br.com.peoplemanagement.impl.mapper.PeopleEntityToResponseImpl;
import br.com.peoplemanagement.impl.mapper.PeopleImplRequestToEntity;
import br.com.peoplemanagement.impl.model.request.PeopleImplRequest;
import br.com.peoplemanagement.impl.model.response.PeopleImplResponse;
import br.com.peoplemanagement.impl.repository.PeopleRepository;
import br.com.peoplemanagement.impl.repository.entity.PeopleEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PeopleService {

    private PeopleRepository peopleRepository;

    public Mono<PeopleImplResponse> createPeople(PeopleImplRequest peopleImplRequest) {
        return validateIdentifierType(peopleImplRequest)
            .flatMap(this::validateIdentifierExists)
            .flatMap(peopleRepository::save)
            .map(PeopleEntityToResponseImpl::mapFrom);
    }

    private Mono<PeopleImplRequest> validateIdentifierType(PeopleImplRequest peopleImplRequest) {
        return Mono.just(peopleImplRequest)
            .map(people -> {
                if (11 == people.getIdentifier().length()) {
                    people.setIdentifierType(IdentifierTypeEnum.CPF);
                } else if (14 == people.getIdentifier().length()) {
                    people.setIdentifierType(IdentifierTypeEnum.CNPJ);
                } else {
                    throw ExceptionUtils.buildError(
                        HttpStatus.CONFLICT,
                        "identificador deve ter 11 digitos para CPF ou 14 digitos para CNPJ"
                    );
                }
                return people;
            });
    }

    private Mono<PeopleEntity> validateIdentifierExists(PeopleImplRequest peopleImplRequest) {
        return peopleRepository.findByIdentifier(peopleImplRequest.getIdentifier())
            .doOnNext(associateEntity -> {
                throw ExceptionUtils.buildError(
                    HttpStatus.CONFLICT,
                    "Já existe uma pessoa registrada com o identificador " + peopleImplRequest.getIdentifier());
            }).switchIfEmpty(Mono.just(peopleImplRequest)
                .map(PeopleImplRequestToEntity::mapFrom));
    }

}
