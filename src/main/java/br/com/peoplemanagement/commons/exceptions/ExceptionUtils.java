package br.com.peoplemanagement.commons.exceptions;

import br.com.peoplemanagement.impl.repository.entity.PeopleEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class ExceptionUtils {

    public static ResponseStatusException buildError(HttpStatus status, String message) {
        return new ResponseStatusException(status, message);
    }

    public static Mono<PeopleEntity> getErrorByIdentifier(String id) {
        return Mono.error(
            new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Identificador informado: " + id + ", não encontrado em nosso cadastro"));
    }

}
