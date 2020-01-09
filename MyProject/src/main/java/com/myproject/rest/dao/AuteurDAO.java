package com.myproject.rest.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.myproject.rest.model.Auteur;

@Repository
public class AuteurDAO {

	public Auteur findById(final Long id) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Auteur auteur = null;

		try (Session session = sessionFactory.openSession()) {
			auteur = session.get(Auteur.class, id);
		}

		return auteur;
	}

	public List<Auteur> findAll() {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		List<Auteur> list = null;

		try (Session session = sessionFactory.openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Auteur> criteria = builder.createQuery(Auteur.class);
			criteria.from(Auteur.class);
			list = session.createQuery(criteria).getResultList();
		}

		return list;
	}

	public Long create(final Auteur resource) {
		return null;
	}

	public void update(final Auteur resource) {

	}

	public void deleteById(final Long id) {

	}
}
