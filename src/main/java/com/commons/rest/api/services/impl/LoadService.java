package com.commons.rest.api.services.impl;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.commons.rest.api.entities.BaseEntity;
import com.commons.rest.api.repositories.IBaseRepository;
import com.commons.rest.api.services.ILoadService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional(readOnly = true)
public class LoadService<E extends BaseEntity, K extends Serializable, R extends IBaseRepository<E, K>>
		extends SearchService<E, K, R>
		implements ILoadService<E, K, R> {

	public LoadService(R repository) {
		super(repository);
	}
	
	@Override
	public Optional<E> findById(K id) {
		if (id == null) { return Optional.empty(); }
		log.debug(String.format("Getting %s registration -> %s", getEntityClass().toString(), id));
		return getRepository().findById(id);
	}

}
