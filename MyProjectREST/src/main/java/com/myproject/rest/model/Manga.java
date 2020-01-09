package com.myproject.rest.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Manga {

	@Id
	@GeneratedValue
	private Long		id;

	@Column
	private String		nom;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "auteurId")
	private Auteur		auteur;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "mangaId")
	private List<Tome>	tomes;

	@OneToMany(mappedBy = "manga")
	private List<Tarif>	tarifs;

	public Manga() {

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

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(final Auteur auteur) {
		this.auteur = auteur;
	}

	public List<Tome> getTomes() {
		return tomes;
	}

	public void setTomes(final List<Tome> tomes) {
		this.tomes = tomes;
	}
}
