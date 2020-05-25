package com.commons.rest.api.controllers.impl;

import java.io.Serializable;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.commons.rest.api.controllers.ISaveAndUpdateController;
import com.commons.rest.api.entities.BaseEntity;
import com.commons.rest.api.repositories.IBaseRepository;
import com.commons.rest.api.services.ISaveAndUpdateService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SaveAndUpdateController<
	    E extends BaseEntity,
	    K extends Serializable,
	    R extends IBaseRepository<E, K>,
	    S extends ISaveAndUpdateService<E, K, R>,
	    M extends RepresentationModel<M>>
    extends DeleteController<E, K, R, S, M>
    implements ISaveAndUpdateController<E, K, R, S, M> {

	public SaveAndUpdateController(S service, PagedResourcesAssembler<E> pagedResourcesAssembler, RepresentationModelAssemblerSupport<E, M> modelAssembler) {
		super(service, pagedResourcesAssembler, modelAssembler);
	}

	@Override
	public ResponseEntity<M> create(@RequestBody @Valid E object) {
		return getService().save(object)
				.map(getModelAssembler()::toModel) 
				.map(entity -> ResponseEntity.status(HttpStatus.CREATED).body(entity)) 
				.orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<M> update(@RequestBody @Valid E object, @PathVariable K id) {
		return getService().update(object, id)
				.map(getModelAssembler()::toModel) 
				.map(ResponseEntity::ok) 
				.orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<M> update(
			@RequestBody Map<String, String> updates,
			@PathVariable K id) throws NoSuchFieldException, IllegalAccessException {
		try {
			return getService().update(updates, id)
			.map(getModelAssembler()::toModel) 
			.map(ResponseEntity::ok) 
			.orElse(ResponseEntity.notFound().build());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.notFound().build();
		}
	}

}