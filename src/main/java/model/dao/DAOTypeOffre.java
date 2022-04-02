package model.dao;

import java.util.List;

import javax.management.Query;
import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.bo.TypeOffre;
import model.service.HibernateUtil;

public class DAOTypeOffre {

	public void inserer(TypeOffre o) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			session.save(o);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	
	public TypeOffre getTypeId(String type) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<TypeOffre> results = session.createQuery("FROM TypeOffre").list();
		session.beginTransaction();
		
		for (TypeOffre object : results) {
			if (object.getLibelle().equals(type)) {
				session.getTransaction().commit();
				session.close();
				return object;
			}
		}
		return null;
	}
	
	
}
