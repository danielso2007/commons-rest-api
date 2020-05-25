package com.commons.rest.api.controllers;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.commons.rest.api.entities.BaseEntity;
import com.commons.rest.api.repositories.IBaseRepository;
import com.commons.rest.api.services.IBaseService;

public interface IBaseController<E extends BaseEntity, K extends Serializable, R extends IBaseRepository<E, K>, S extends IBaseService<E, K, R>, M extends RepresentationModel<M>> {

}
