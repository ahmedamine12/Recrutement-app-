package model.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.bo.Offre;
import model.bo.TypeOffre;
import model.bo.User;
import model.dao.DAOOffre;
import model.dao.DAOTypeOffre;
import model.dao.DAOUser;

public class test {
	public static void main(String[] args) {

		// SessionFactory in Hibernate 5 example
		Configuration config = new Configuration();
		config.configure("/model/service/hibernate.cfg.xml");
		// local SessionFactory bean created
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		Offre o = new Offre();
//
//		User u = new DAOUser().getUserById(1);
//		TypeOffre to = new DAOTypeOffre().getTypeId("cdi");
//
//		System.out.println(u);
//		System.out.println(to);
//
//		o.setTitre("toto");
//		o.setDescription("hellloooooooooo");
//		o.setType(to);
//		o.setCreateur(u);
//
//		new DAOOffre().insererOffre(o);
//		session.getTransaction().commit();
//		session.close();
//	
	}
}
