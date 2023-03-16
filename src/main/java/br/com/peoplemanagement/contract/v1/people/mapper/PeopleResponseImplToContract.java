package br.com.peoplemanagement.contract.v1.people.mapper;

import br.com.peoplemanagement.contract.v1.people.model.response.PeopleContractResponse;
import br.com.peoplemanagement.impl.model.response.PeopleImplResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PeopleResponseImplToContract {

    static PeopleContractResponse mapFrom(PeopleImplResponse peopleImplResponse) {
        return Mappers.getMapper(PeopleResponseImplToContract.class)
            .mapper(peopleImplResponse);
    }

    PeopleContractResponse mapper(PeopleImplResponse peopleImplResponse);

}
