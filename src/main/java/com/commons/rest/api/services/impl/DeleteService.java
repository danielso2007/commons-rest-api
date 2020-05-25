package com.commons.rest.api.services.impl;

import java.io.Serializable;

import org.springframework.transaction.annotation.Transactional;

import com.commons.rest.api.entities.BaseEntity;
import com.commons.rest.api.repositories.IBaseRepository;
import com.commons.rest.api.services.IDeleteService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional(readOnly = true)
public class DeleteService<E extends BaseEntity, K extends Serializable, R extends IBaseRepository<E, K>>
        extends LoadService<E, K, R>
		implements IDeleteService<E, K, R> {

	public DeleteService(R repository) {
		super(repository);
	}

	@Override
	public void delete(K id) {
		log.debug(String.format("Deleting record %s: %s", getEntityClass().toString(), id));
		getRepository().deleteById(id);
	}

}
