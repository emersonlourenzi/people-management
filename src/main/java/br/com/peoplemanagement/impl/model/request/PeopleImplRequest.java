package br.com.peoplemanagement.impl.model.request;

import br.com.peoplemanagement.commons.enums.IdentifierTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PeopleImplRequest {

    private String name;
    private String identifier;
    private IdentifierTypeEnum identifierType;


}
