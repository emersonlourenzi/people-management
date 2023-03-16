package br.com.peoplemanagement.contract.v1.people.mapper;

import br.com.peoplemanagement.contract.v1.people.model.request.PeopleContractRequest;
import br.com.peoplemanagement.impl.model.request.PeopleImplRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PeopleRequestContractToImpl {

    static PeopleImplRequest mapFrom(PeopleContractRequest peopleContractRequest) {
        return Mappers.getMapper(PeopleRequestContractToImpl.class)
            .mapper(peopleContractRequest);
    }

    PeopleImplRequest mapper(PeopleContractRequest peopleContractRequest);

}
