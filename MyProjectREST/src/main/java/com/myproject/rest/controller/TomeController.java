package com.myproject.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.rest.dao.TomeDAO;
import com.myproject.rest.model.Auteur;
import com.myproject.rest.model.Manga;
import com.myproject.rest.model.Tome;

@RestController
@RequestMapping(path = "/tomes")
public class TomeController
	extends CRUDGenericController<Tome> {
	
	@GetMapping(value = "/upcoming")
	public List<Tome> findUpcoming() {
		return ((TomeDAO)crudDao).findUpcoming();
	}
}
