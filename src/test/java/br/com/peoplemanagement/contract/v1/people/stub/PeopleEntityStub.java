package br.com.peoplemanagement.contract.v1.people.stub;

import br.com.peoplemanagement.commons.enums.IdentifierTypeEnum;
import br.com.peoplemanagement.impl.repository.entity.PeopleEntity;

public class PeopleEntityStub {

    public static PeopleEntity stubPeopleEntity() {
        return PeopleEntity.builder()
            .name("name")
            .identifier("12345678910")
            .identifierType(IdentifierTypeEnum.CPF)
            .build();
    }

    public static PeopleEntity stubPeopleEntityError() {
        return PeopleEntity.builder()
            .name("name")
            .identifier("12345678910")
            .identifierType(IdentifierTypeEnum.CPF)
            .build();
    }

}
