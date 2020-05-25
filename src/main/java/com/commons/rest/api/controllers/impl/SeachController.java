package com.commons.rest.api.controllers.impl;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.commons.rest.api.IConstantsAPI;
import com.commons.rest.api.controllers.ISearchController;
import com.commons.rest.api.entities.BaseEntity;
import com.commons.rest.api.repositories.IBaseRepository;
import com.commons.rest.api.services.ISearchService;

public class SeachController<
	    E extends BaseEntity,
	    K extends Serializable,
	    R extends IBaseRepository<E, K>,
	    S extends ISearchService<E, K, R>,
	    M extends RepresentationModel<M>>
    extends BaseController<E, K, R, S, M>
    implements ISearchController<E, K, R, S, M> {

	public SeachController(S service, PagedResourcesAssembler<E> pagedResourcesAssembler, RepresentationModelAssemblerSupport<E, M> modelAssembler) {
		super(service, pagedResourcesAssembler, modelAssembler);
	}

	@Override
	public ResponseEntity<CollectionModel<M>> findAll(
			@RequestParam(value = "page", required = false, defaultValue = IConstantsAPI.DEFAULT_PAGE) int page,
			@RequestParam(value = "size", required = false, defaultValue = IConstantsAPI.DEFAULT_SIZE) int size,
			@RequestParam(required = false) Map<String,String> filters) {
		return ResponseEntity.ok().body(getPagedResourcesAssembler().toModel(getService().findPaginated(page, size, filters), getModelAssembler()));
	}
	
}