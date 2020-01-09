package com.myproject.rest.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.myproject.rest.model.key.TarifId;

@Entity
public class Tarif {

	@EmbeddedId
	private final TarifId	id	= new TarifId();

	@ManyToOne
	@MapsId("mangaId")
	private Manga			manga;

	@ManyToOne
	@MapsId("magasinId")
	private Magasin			magasin;

	private Double			prix;

	public Manga getManga() {
		return manga;
	}

	public void setManga(final Manga manga) {
		this.manga = manga;
	}

	public Magasin getMagasin() {
		return magasin;
	}

	public void setMagasin(final Magasin magasin) {
		this.magasin = magasin;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(final Double prix) {
		this.prix = prix;
	}

	public TarifId getId() {
		return id;
	}

}
