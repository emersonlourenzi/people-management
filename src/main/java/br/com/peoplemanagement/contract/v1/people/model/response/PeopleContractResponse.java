package br.com.peoplemanagement.contract.v1.people.model.response;

import br.com.peoplemanagement.commons.enums.IdentifierTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PeopleContractResponse {

    private String name;
    private String identifier;
    private IdentifierTypeEnum identifierType;

}
