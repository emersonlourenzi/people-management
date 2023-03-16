package br.com.peoplemanagement.impl;

import br.com.peoplemanagement.commons.enums.IdentifierTypeEnum;
import br.com.peoplemanagement.impl.mapper.PeopleEntityToResponseImpl;
import br.com.peoplemanagement.impl.mapper.PeopleImplRequestToEntity;
import br.com.peoplemanagement.impl.model.request.PeopleImplRequest;
import br.com.peoplemanagement.impl.model.response.PeopleImplResponse;
import br.com.peoplemanagement.impl.repository.PeopleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PeopleService {

    private PeopleRepository peopleRepository;

    public Mono<PeopleImplResponse> createPeople(PeopleImplRequest peopleImplRequest) {
        return validateIdentifierType(peopleImplRequest)
            .map(PeopleImplRequestToEntity::mapFrom)
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
                }
                return people;
            });
    }

}
