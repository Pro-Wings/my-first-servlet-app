package com.prowings.dao;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure(new File("C:\\Users\\Shree\\eclipse-workspace\\my-first-servlet-app\\src\\main\\webapp\\WEB-INF\\hibernate.cfg.xml")).buildSessionFactory();
			return sessionFactory;
		} else
			return sessionFactory;
	}

}
