package com.myproject.rest.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Auteur {

	@Id
	@GeneratedValue
	private Long		id;

	@Column
	private String		nom;

	@Column
	private String		prenom;

	@OneToMany(mappedBy = "auteur", fetch = FetchType.EAGER)
	private List<Manga>	mangas;

	public Auteur() {

	}

	public Auteur(final Long id, final String nom, final String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(final String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(final String prenom) {
		this.prenom = prenom;
	}

	public List<Manga> getMangas() {
		return mangas;
	}

	public void setMangas(final List<Manga> mangas) {
		this.mangas = mangas;
	}
}