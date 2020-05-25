package com.commons.rest.api.services;

import java.io.Serializable;
import java.util.Optional;

import com.commons.rest.api.entities.BaseEntity;
import com.commons.rest.api.repositories.IBaseRepository;

public interface ILoadService<E extends BaseEntity, K extends Serializable, R extends IBaseRepository<E, K>>
	extends ISearchService<E, K, R> {

	Optional<E> findById(final K id);

}
