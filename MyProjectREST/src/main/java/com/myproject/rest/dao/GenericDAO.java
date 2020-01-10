package com.myproject.rest.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import com.myproject.rest.util.HibernateUtil;

public class GenericDAO<T> {

	private final Class<T> clazzT;

	public GenericDAO() {
		clazzT = null;
	}

	public GenericDAO(final Class<T> clazzT) {
		this.clazzT = clazzT;
	}

	public T findOne(final Long id) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(clazzT, id);
		}
	}

	public List<T> findAll() {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<T> criteria = builder.createQuery(clazzT);
			criteria.from(clazzT);
			return session.createQuery(criteria).getResultList();
		}
	}

	public T create(final T entity) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
			return entity;
		}
	}

	public T update(final T entity) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.update(entity);
			session.getTransaction().commit();
			return entity;
		}
	}

	public void delete(final T entity) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();
		}
	}

	public void deleteById(final Long entityId) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			T entity = findOne(entityId);
			delete(entity);
		}
	}
}
