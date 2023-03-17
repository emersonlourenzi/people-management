package br.com.peoplemanagement.commons.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
public class ExceptionUtils {

    public static ResponseStatusException buildError(HttpStatus status, String message) {
        return new ResponseStatusException(status, message);
    }

}
