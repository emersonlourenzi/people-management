package br.com.peoplemanagement.impl.repository.entity;

import br.com.peoplemanagement.commons.enums.IdentifierTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PeopleEntity {

    private String name;
    private String identifier;
    private IdentifierTypeEnum identifierType;

}
