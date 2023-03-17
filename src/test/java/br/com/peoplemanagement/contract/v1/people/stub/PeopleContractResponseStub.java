package br.com.peoplemanagement.contract.v1.people.stub;

import br.com.peoplemanagement.commons.enums.IdentifierTypeEnum;
import br.com.peoplemanagement.contract.v1.people.model.response.PeopleContractResponse;

public class PeopleContractResponseStub {

    public static PeopleContractResponse stubPeopleContractResponse() {
        return PeopleContractResponse.builder()
            .name("name")
            .identifier("12345678910")
            .identifierType(IdentifierTypeEnum.CPF)
            .build();
    }

}
