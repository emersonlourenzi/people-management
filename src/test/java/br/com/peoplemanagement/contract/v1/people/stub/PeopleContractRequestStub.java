package br.com.peoplemanagement.contract.v1.people.stub;

import br.com.peoplemanagement.contract.v1.people.model.request.PeopleContractRequest;

public class PeopleContractRequestStub {

    public static PeopleContractRequest stubPeopleContractRequest() {
        return PeopleContractRequest.builder()
            .name("name")
            .identifier("12345678910")
            .build();
    }

    public static PeopleContractRequest stubPeopleContractRequestError() {
        return PeopleContractRequest.builder()
            .name("name")
            .identifier("12345678910")
            .build();
    }

}
