package com.myproject.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.myproject.rest.model.Auteur;

@Repository
public class AuteurDAO {
	private static List<Auteur>	auteurs	= new ArrayList<>();

	Long						freeId	= 4L;

	static {
		auteurs.add(new Auteur(1L, "Lokesh", "Gupta"));
		auteurs.add(new Auteur(2L, "Alex", "Kolenchiskey"));
		auteurs.add(new Auteur(3L, "David", "Kameron"));
	}

	public List<Auteur> findAll() {
		return auteurs;
	}

	public Auteur findById(final Long id) {

		for (Auteur auteur : auteurs) {
			if (auteur.getId().equals(id)) {
				return auteur;
			}
		}

		return null;
	}

	public Long create(final Auteur resource) {

		Long id = freeId++;
		resource.setId(id);
		auteurs.add(resource);

		return id;
	}

	public void update(final Auteur resource) {

		deleteById(resource.getId());
		auteurs.add(resource);
	}

	public void deleteById(final Long id) {

		List<Auteur> rmLst = new ArrayList<>();

		for (Auteur auteur : auteurs) {
			if (auteur.getId().equals(id)) {
				rmLst.add(auteur);
			}
		}

		auteurs.removeAll(rmLst);
	}
}
