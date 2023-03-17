package br.com.peoplemanagement.contract.v1.people;

import br.com.peoplemanagement.contract.v1.people.mapper.PeopleRequestContractToImpl;
import br.com.peoplemanagement.contract.v1.people.mapper.PeopleResponseImplToContract;
import br.com.peoplemanagement.contract.v1.people.model.request.PeopleContractRequest;
import br.com.peoplemanagement.contract.v1.people.model.response.PeopleContractResponse;
import br.com.peoplemanagement.contract.v1.people.swagger.CreatePeopleSwagger;
import br.com.peoplemanagement.contract.v1.people.swagger.GetPeopleSwagger;
import br.com.peoplemanagement.impl.PeopleService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@Api(tags = "Serviço gerenciamento pessoa")
@RequestMapping(path = "/v1/people")
public class PeopleRestController {

    private PeopleService peopleService;

    @PostMapping("/create")
    @CreatePeopleSwagger
    public Mono<PeopleContractResponse> createPeople(@RequestBody @Valid PeopleContractRequest peopleContractRequest) {
        return peopleService.createPeople(PeopleRequestContractToImpl.mapFrom(peopleContractRequest))
            .map(PeopleResponseImplToContract::mapFrom);
    }

    @GetMapping("/find/{id}")
    @GetPeopleSwagger
    public Mono<PeopleContractResponse> findPeopleByIdentifier(@PathVariable String id) {
        return peopleService.findPeopleByIdentifier(id)
            .map(PeopleResponseImplToContract::mapFrom);
    }

}
