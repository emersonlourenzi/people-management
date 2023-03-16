package br.com.peoplemanagement.impl.mapper;

import br.com.peoplemanagement.impl.model.response.PeopleImplResponse;
import br.com.peoplemanagement.impl.repository.entity.PeopleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PeopleEntityToResponseImpl {

    static PeopleImplResponse mapFrom(PeopleEntity peopleEntity) {
        return Mappers.getMapper(PeopleEntityToResponseImpl.class)
            .mapper(peopleEntity);
    }

    PeopleImplResponse mapper(PeopleEntity peopleEntity);

}
