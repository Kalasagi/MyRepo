package com.myproject.rest.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private HibernateUtil() {
	}

	private static SessionFactory sessionFactory;

	static {

		sessionFactory = buildSessionFactory();

	}

	private static SessionFactory buildSessionFactory() {

		return new Configuration().configure().buildSessionFactory();

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}