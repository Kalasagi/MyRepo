package com.myproject.rest.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.myproject.rest.model.Manga;
import com.myproject.rest.util.HibernateUtil;

@Repository
public class MangaDAO
	extends CRUDGenericDAO<Manga> {

	public MangaDAO() {
		super(Manga.class);
	}

	public List<Manga> findUpcoming() {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Manga> criteria = builder.createQuery(Manga.class);
			Root<Manga> root = criteria.from(Manga.class);

			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);

			criteria.select(root).where(builder.gt(root.get("dateDeSortie"), cal.getTimeInMillis()));
			return session.createQuery(criteria).getResultList();

		}
	}
}
