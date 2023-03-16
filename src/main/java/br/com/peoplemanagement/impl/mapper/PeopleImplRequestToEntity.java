package br.com.peoplemanagement.impl.mapper;

import br.com.peoplemanagement.impl.model.request.PeopleImplRequest;
import br.com.peoplemanagement.impl.repository.entity.PeopleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PeopleImplRequestToEntity {

    static PeopleEntity mapFrom(PeopleImplRequest peopleImplRequest) {
        return Mappers.getMapper(PeopleImplRequestToEntity.class)
            .mapper(peopleImplRequest);
    }

    PeopleEntity mapper(PeopleImplRequest peopleImplRequest);

}
