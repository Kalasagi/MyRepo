package com.myproject.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.myproject.rest.dao.CRUDGenericDAO;

public class CRUDGenericController<T> {

	@Autowired
	private CRUDGenericDAO<T> crudDao;

	@GetMapping
	public List<T> findAll() {
		return crudDao.findAll();
	}

	@GetMapping(value = "/{id}")
	public T findById(@PathVariable("id") final Long id) {
		return crudDao.findOne(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public T create(@RequestBody final T resource) {
		return crudDao.create(resource);
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable("id") final Long id, @RequestBody final T resource) {
		crudDao.update(resource);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") final Long id) {
		crudDao.deleteById(id);
	}
}
