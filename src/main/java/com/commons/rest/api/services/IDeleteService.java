package com.commons.rest.api.services;

import java.io.Serializable;

import com.commons.rest.api.entities.BaseEntity;
import com.commons.rest.api.repositories.IBaseRepository;

public interface IDeleteService<E extends BaseEntity, K extends Serializable, R extends IBaseRepository<E, K>>
	extends ILoadService<E, K, R> {

	void delete(final K id);

}
