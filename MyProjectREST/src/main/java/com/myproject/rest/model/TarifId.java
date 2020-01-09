package com.myproject.rest.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class TarifId
	implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private Long				mangaId;
	private Long				magasinId;

	public TarifId() {

	}

	public TarifId(final Long mangaId, final Long magasinId) {
		super();
		this.mangaId = mangaId;
		this.magasinId = magasinId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (mangaId == null ? 0 : mangaId.hashCode());
		result = prime * result + (magasinId == null ? 0 : magasinId.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		TarifId other = (TarifId) obj;
		return Objects.equals(getMangaId(), other.getMangaId()) && Objects.equals(getMagasinId(), other.getMagasinId());
	}

	public Long getMangaId() {
		return mangaId;
	}

	public void setMangaId(final Long mangaId) {
		this.mangaId = mangaId;
	}

	public Long getMagasinId() {
		return magasinId;
	}

	public void setMagasinId(final Long magasinId) {
		this.magasinId = magasinId;
	}
}
