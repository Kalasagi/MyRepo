package com.myproject.rest.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Tome {

	@Id
	@GeneratedValue
	private Long	id;

	@Column
	private String	Titre;

	@Column
	private String	Numero;

	@OneToMany
	@JoinColumn(name = "tome_id")
	List<Chapitre>	chapitres;

	public Tome() {

	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getTitre() {
		return Titre;
	}

	public void setTitre(final String titre) {
		Titre = titre;
	}

	public String getNumero() {
		return Numero;
	}

	public void setNumero(final String numero) {
		Numero = numero;
	}

	public List<Chapitre> getChapitres() {
		return chapitres;
	}

	public void setChapitres(final List<Chapitre> chapitres) {
		this.chapitres = chapitres;
	}

}
