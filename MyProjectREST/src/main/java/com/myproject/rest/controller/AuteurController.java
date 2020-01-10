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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.rest.dao.AuteurDAO;
import com.myproject.rest.model.Auteur;

@RestController
@RequestMapping(path = "/auteurs")
public class AuteurController {

	@Autowired
	private AuteurDAO auteurDao;

	@GetMapping
	public List<Auteur> findAll() {
		return auteurDao.findAll();
	}

	@GetMapping(value = "/{id}")
	public Auteur findById(@PathVariable("id") final Long id) {
		return auteurDao.findOne(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Long create(@RequestBody final Auteur resource) {
		return auteurDao.create(resource).getId();
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable("id") final Long id, @RequestBody final Auteur resource) {
		auteurDao.update(resource);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") final Long id) {
		auteurDao.deleteById(id);
	}

}
