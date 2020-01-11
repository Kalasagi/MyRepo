package com.myproject.rest.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.myproject.rest.model.Manga;
import com.myproject.rest.model.Tome;
import com.myproject.rest.util.HibernateUtil;

@Repository
public class TomeDAO
	extends CRUDGenericDAO<Tome> {

	public TomeDAO() {
		super(Tome.class);
	}

	public List<Tome> findUpcoming() {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Tome> criteria = builder.createQuery(Tome.class);
			Root<Tome> root = criteria.from(Tome.class);

			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			
			
			//Predicate p1 = builder.greaterThan(root.get("dateDeSortieFR") ,cal.getTime());
			//Predicate p2 = builder.isNull(root.get("dateDeSortieFR"));
			//criteria.select(root).where(builder.or(p1, p2));
			criteria.select(root).where(builder.greaterThan(root.get("dateDeSortieFR") ,cal.getTime()));

			return session.createQuery(criteria).getResultList();

		}
	}
}
