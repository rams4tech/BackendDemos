package org.thinkadv.rest.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHibernate {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Retreivee
		Employee employee = (Employee) session.get(Employee.class, 1);
		System.out.println(employee);
	}

}
