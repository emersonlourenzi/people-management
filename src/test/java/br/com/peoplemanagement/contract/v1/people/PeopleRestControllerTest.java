package br.com.peoplemanagement.contract.v1.people;

import br.com.peoplemanagement.impl.PeopleService;
import br.com.peoplemanagement.impl.repository.PeopleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static br.com.peoplemanagement.contract.v1.people.stub.PeopleContractRequestStub.stubPeopleContractRequest;
import static br.com.peoplemanagement.contract.v1.people.stub.PeopleContractRequestStub.stubPeopleContractRequestError;
import static br.com.peoplemanagement.contract.v1.people.stub.PeopleContractResponseStub.stubPeopleContractResponse;
import static br.com.peoplemanagement.contract.v1.people.stub.PeopleEntityStub.stubPeopleEntity;
import static br.com.peoplemanagement.contract.v1.people.stub.PeopleEntityStub.stubPeopleEntityError;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
    PeopleRestController.class,
    PeopleService.class
})
class PeopleRestControllerTest {

    @Autowired
    PeopleRestController peopleRestController;
    @MockBean
    PeopleRepository peopleRepository;

    @Test
    void testCreatePeopleSuccess() {
        var mockRequestContract = stubPeopleContractRequest();
        var mockResponseContract = stubPeopleContractResponse();
        var mockEntity = stubPeopleEntity();

        Mockito.when(peopleRepository.save(mockEntity))
            .thenReturn(Mono.just(mockEntity));
        Mockito.when(peopleRepository.findByIdentifier(mockRequestContract.getIdentifier()))
            .thenReturn(Mono.empty());

        StepVerifier.create(peopleRestController.createPeople(mockRequestContract))
            .assertNext(response -> Assertions.assertEquals(mockResponseContract, response))
            .verifyComplete();
    }

    @Test
    void testCreatePeopleErro() {
        var mockRequestContract = stubPeopleContractRequestError();
        var mockEntity = stubPeopleEntityError();

        Mockito.when(peopleRepository.findByIdentifier(mockRequestContract.getIdentifier()))
            .thenReturn(Mono.just(mockEntity));

        StepVerifier.create(peopleRestController.createPeople(mockRequestContract))
            .expectError()
            .verify();
    }

    @Test
    void testFindPeopleByIdentifier() {
        var identifier = "12345678910";
        var mockResponseContract = stubPeopleContractResponse();
        var mockEntity = stubPeopleEntity();

        Mockito.when(peopleRepository.findByIdentifier(identifier))
            .thenReturn(Mono.just(mockEntity));

        StepVerifier.create(peopleRestController.findPeopleByIdentifier(identifier))
            .assertNext(response -> Assertions.assertEquals(mockResponseContract, response))
            .verifyComplete();
    }

}