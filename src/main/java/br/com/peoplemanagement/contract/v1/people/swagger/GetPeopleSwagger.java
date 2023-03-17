package br.com.peoplemanagement.contract.v1.people.swagger;

import br.com.peoplemanagement.contract.v1.people.model.response.PeopleContractResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiOperation(value = "Busca pessoa por identificador", response = PeopleContractResponse.class,
    responseContainer = "Mono", produces = "application/json")
@ApiResponses({
    @ApiResponse(code = 200, message = "Busca pessoa sucesso"),
    @ApiResponse(code = 404, message = "Pessoa nāo encontrada"),
    @ApiResponse(code = 409, message = "Conflito na busca pessoa"),
    @ApiResponse(code = 500, message = "Internal error", response = Error.class)
})
public @interface GetPeopleSwagger {
}
