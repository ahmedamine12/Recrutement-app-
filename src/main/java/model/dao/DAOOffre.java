package model.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.bo.Offre;
import model.bo.User;
import model.service.HibernateUtil;

public class DAOOffre {
	public void insererOffre(Offre o) {
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


	public List<Offre> getListOffres() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Offre> offres;
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			offres=(List<Offre>)session.createQuery("from Offre").list();
			tx.commit();
			return offres;
			
		}catch (HibernateException e) {
			// TODO: handle exception
			tx.rollback();
		}

		return null;

	}

	public Offre getOffreByID(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		return session.load(Offre.class, id);
	}
	
	
	public void updateOffre(Offre o) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			session.update(o);
			// commit transaction
			session.flush();
			transaction.commit();
			session.close();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.getMessage();
		}

	}
	
	
	public void supprimerOffre(Offre o) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			session.delete(o);
			System.out.println("Dans supprimerOffre");
			// commit transaction
			session.flush();
			transaction.commit();
			session.close();
		} catch (Exception e) {
//			if (transaction != null) {
//				transaction.rollback();
//			}
			e.getMessage();
		}
	}
}
