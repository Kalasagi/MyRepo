package com.myproject.rest.dao;

import org.springframework.stereotype.Repository;

import com.myproject.rest.model.Auteur;

@Repository
public class AuteurDAO
	extends CRUDGenericDAO<Auteur> {

	public AuteurDAO() {
		super(Auteur.class);
	}

}
