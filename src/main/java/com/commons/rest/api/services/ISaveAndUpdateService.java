package com.commons.rest.api.services;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

import com.commons.rest.api.entities.BaseEntity;
import com.commons.rest.api.repositories.IBaseRepository;

public interface ISaveAndUpdateService<E extends BaseEntity, K extends Serializable, R extends IBaseRepository<E, K>>
	extends IDeleteService<E, K, R> {

	Optional<E> save(E object);

	Optional<E> update(Map<String, String> updates, final K id) throws IllegalAccessException;

	Optional<E> update(E object, final K id);

}
