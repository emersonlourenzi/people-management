package br.com.peoplemanagement.contract.v1.people.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Pessoa")
public class PeopleContractRequest {

    @ApiModelProperty(value = "Nome pessoa")
    @NotEmpty(message = "Nome pessoa não pode ser vazio ou nulo")
    private String name;
    @ApiModelProperty(value = "Número de identificaçāo pessoa")
    @NotEmpty(message = "Número de identificaçāo pessoa não pode ser vazio ou nulo")
    private String identifier;

}
