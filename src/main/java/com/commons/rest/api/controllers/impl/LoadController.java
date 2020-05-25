package com.commons.rest.api.controllers.impl;

import java.io.Serializable;

import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.commons.rest.api.controllers.ILoadController;
import com.commons.rest.api.entities.BaseEntity;
import com.commons.rest.api.repositories.IBaseRepository;
import com.commons.rest.api.services.ILoadService;

public class LoadController<
	    E extends BaseEntity,
	    K extends Serializable,
	    R extends IBaseRepository<E, K>,
	    S extends ILoadService<E, K, R>,
	    M extends RepresentationModel<M>>
    extends SeachController<E, K, R, S, M>
    implements ILoadController<E, K, R, S, M> {

	public LoadController(S service, PagedResourcesAssembler<E> pagedResourcesAssembler, RepresentationModelAssemblerSupport<E, M> modelAssembler) {
		super(service, pagedResourcesAssembler, modelAssembler);
	}

	@Override
	public ResponseEntity<M> find(@PathVariable K id) {
		return getService().findById(id) 
			.map(getModelAssembler()::toModel) 
			.map(ResponseEntity::ok) 
			.orElse(ResponseEntity.notFound().build());
	}

}