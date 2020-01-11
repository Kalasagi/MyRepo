package com.myproject.rest.dao;

import org.springframework.stereotype.Repository;

import com.myproject.rest.model.Manga;

@Repository
public class MangaDAO
	extends CRUDGenericDAO<Manga> {

	public MangaDAO() {
		super(Manga.class);
	}
}
