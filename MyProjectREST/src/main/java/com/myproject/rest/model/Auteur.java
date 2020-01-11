package com.myproject.rest.model;

import java.util.List;

import javax.persistence.CascadeType;
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
	private String		pseudo;

	@OneToMany(mappedBy = "auteur", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Manga>	mangas;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}


	public List<Manga> getMangas() {
		return mangas;
	}

	public void setMangas(final List<Manga> mangas) {
		this.mangas = mangas;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	
}