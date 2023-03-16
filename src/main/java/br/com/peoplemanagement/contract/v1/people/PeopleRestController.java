package br.com.peoplemanagement.contract.v1.people;

import br.com.peoplemanagement.contract.v1.people.model.request.PeopleContractRequest;
import br.com.peoplemanagement.contract.v1.people.model.response.PeopleContractResponse;
import br.com.peoplemanagement.contract.v1.people.swagger.CreatePeopleSwagger;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@Api(tags = "Serviço gerenciamento pessoa")
@RequestMapping(path = "/v1/people")
public class PeopleRestController {

    @PostMapping("/create")
    @CreatePeopleSwagger
    public Mono<PeopleContractResponse> createPeople(@RequestBody @Valid PeopleContractRequest peopleContractRequest) {
        return null;
    }

}
