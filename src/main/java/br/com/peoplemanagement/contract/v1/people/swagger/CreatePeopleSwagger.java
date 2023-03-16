package br.com.peoplemanagement.contract.v1.people.swagger;

import br.com.peoplemanagement.contract.v1.people.model.response.PeopleContractResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiOperation(value = "Cria pessoa", response = PeopleContractResponse.class,
    responseContainer = "Mono", produces = "application/json")
@ApiResponses({
    @ApiResponse(code = 200, message = "Pessoa criado com sucesso"),
    @ApiResponse(code = 409, message = "Conflito na criação pessoa"),
    @ApiResponse(code = 500, message = "Internal error", response = Error.class)
})
public @interface CreatePeopleSwagger {
}
