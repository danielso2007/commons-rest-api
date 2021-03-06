package com.commons.rest.api.controllers;

import java.io.Serializable;

import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.commons.rest.api.IConstantsAPI;
import com.commons.rest.api.entities.BaseEntity;
import com.commons.rest.api.repositories.IBaseRepository;
import com.commons.rest.api.services.IDeleteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * Controle básico de delete de registro.
 * @author Daniel Oliveira
 *
 * @param <E> Representa a entidade.
 * @param <K> Representa o tipo identificador da entidade.
 * @param <R> Representa o repositório do entidade.
 * @param <S> Representa o serviço da entidade.
 */
public interface IDeleteController<
		E extends BaseEntity, 
		K extends Serializable, 
		R extends IBaseRepository<E, K>, 
		S extends IDeleteService<E, K, R>, 
		M extends RepresentationModel<M>>
    extends ISearchController<E, K, R, S, M> {

	@Override
	S getService();

	@Override
	PagedResourcesAssembler<E> getPagedResourcesAssembler();
	
	@Override
	RepresentationModelAssemblerSupport<E, M> getModelAssembler();

	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping(value = "/{id}", produces = { IConstantsAPI.APPLICATION_JSON_UTF_8, IConstantsAPI.APPLICATION_XML_UTF_8 })
	@Operation(summary = "Deleta um registro.", description = "Remove o registro da base de dados.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Registro deletado com sucesso"),
			@ApiResponse(responseCode = "404", description = "Registro não encontrado."),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor") })
	ResponseEntity<Object> delete(@Parameter(description="Id do registro a ser deletado. Não pode ser vazio.", required=true) K id);

}
