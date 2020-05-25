package com.commons.rest.api.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;

import com.commons.rest.api.entities.BaseEntity;
import com.commons.rest.api.repositories.IBaseRepository;

public interface IBaseService<E extends BaseEntity, K extends Serializable, R extends IBaseRepository<E, K>> {

	UserDetails getUser();
	MongoTemplate getTemplate();
	Class<?> getFieldType(String field);
	Class<E> getEntityClass();
	R getRepository();
	Query addCriterias(Query query, List<Criteria> criterias);
	void checkAuditedEntity(E entity);

}
