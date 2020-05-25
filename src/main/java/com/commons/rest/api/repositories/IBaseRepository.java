package com.commons.rest.api.repositories;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.commons.rest.api.entities.BaseEntity;

/**
 * O repositório base da aplicação.
 *
 * @param <E>  A entidade.
 * @param <K> O tipo da identificação das entidades.
 */
@NoRepositoryBean
public interface IBaseRepository<E extends BaseEntity, K extends Serializable> extends MongoRepository<E, K>, QueryByExampleExecutor<E> {
}
