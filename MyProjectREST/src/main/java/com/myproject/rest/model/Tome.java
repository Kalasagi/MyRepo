package com.myproject.rest.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * @author Kalasagi
 *
 */
@Entity
public class Tome {

	@Id
	@GeneratedValue
	private Long	id;

	@Column
	private String	titre;

	@Column
	private String	numero;
	
	@Column(length = 4000)
	private String		synopsis;

	@Column
	private Date	dateDeSortieFR;
	
	@Column
	private Date	dateDeSortieJPN;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "tomeId")
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

	public List<Chapitre> getChapitres() {
		return chapitres;
	}

	public void setChapitres(final List<Chapitre> chapitres) {
		this.chapitres = chapitres;
	}

	public Date getDateDeSortieFR() {
		return dateDeSortieFR;
	}

	public void setDateDeSortieFR(Date dateDeSortieFR) {
		this.dateDeSortieFR = dateDeSortieFR;
	}

	public Date getDateDeSortieJPN() {
		return dateDeSortieJPN;
	}

	public void setDateDeSortieJPN(Date dateDeSortieJPN) {
		this.dateDeSortieJPN = dateDeSortieJPN;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	
}
