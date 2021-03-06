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
	private String	titre;

	@Column
	private String	numero;

	public Chapitre() {

	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(final String titre) {
		this.titre = titre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(final String numero) {
		this.numero = numero;
	}

}
