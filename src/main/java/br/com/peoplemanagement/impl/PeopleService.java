package br.com.peoplemanagement.impl;

import br.com.peoplemanagement.impl.model.request.PeopleImplRequest;
import br.com.peoplemanagement.impl.model.response.PeopleImplResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PeopleService {

    public Mono<PeopleImplResponse> createPeople(PeopleImplRequest peopleImplRequest) {
        return null;
    }

}
