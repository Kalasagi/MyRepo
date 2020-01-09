package com.myproject.rest.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.rest.model.Auteur;

@Repository
public class AuteurDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Auteur findById(final Long id) {

		return sessionFactory.getCurrentSession().get(Auteur.class, id);
	}

	public List<Auteur> findAll() {

		Session session = sessionFactory.getCurrentSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Auteur> criteria = builder.createQuery(Auteur.class);
		criteria.from(Auteur.class);

		return session.createQuery(criteria).getResultList();
	}

	public Long create(final Auteur resource) {
		return null;
	}

	public void update(final Auteur resource) {

	}

	public void deleteById(final Long id) {

	}
}
