package com.myproject.rest.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.myproject.rest.model.Auteur;
import com.myproject.rest.util.HibernateUtil;

@Repository
public class AuteurDAO {

	public Auteur findById(final Long id) {

		Auteur auteur = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			auteur = session.get(Auteur.class, id);
		}

		return auteur;
	}

	public List<Auteur> findAll() {

		List<Auteur> res = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Auteur> criteria = builder.createQuery(Auteur.class);
			criteria.from(Auteur.class);
			res = session.createQuery(criteria).getResultList();
		}

		return res;
	}

	public Long create(final Auteur resource) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.save(resource);
			session.getTransaction().commit();
		}
		return resource.getId();
	}

	public void update(final Auteur resource) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.update(resource);
			session.getTransaction().commit();
		}
	}

	public void deleteById(final Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			Auteur auteur = session.load(Auteur.class, id);
			session.delete(auteur);
			session.getTransaction().commit();
		}
	}
}
