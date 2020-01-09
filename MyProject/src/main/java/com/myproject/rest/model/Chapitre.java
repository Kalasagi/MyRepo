package com.myproject.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Chapitre {

	@Id
	@GeneratedValue
	private Long	id;

	@Column
	private String	Titre;

	@Column
	private String	Numero;

	public Chapitre() {

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

}
