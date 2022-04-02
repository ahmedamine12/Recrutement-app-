package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.bo.TypeOffre;
import model.bo.User;
import model.service.HibernateUtil;

public class DAOUser {

	public void saveUser(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(user);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

//INSERT INTO `users` (`id`, `first_name`, `last_name`, `password`, `user_name`) VALUES (NULL, 'rida', 'brd', '123', 'toto');
	public User validate(String userName, String password) {

		Transaction transaction = null;
		User user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			user = (User) session.createQuery("FROM User U WHERE U.email = :userName").setParameter("userName", userName).uniqueResult();
			System.out.println(user);
			if (user != null && user.getPassword().equals(password)) {
				return user;
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
//			if (transaction != null) {
//				transaction.rollback();
//			}
			e.printStackTrace();
		}
		return null;
	}
	
	public User getUserById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<User> results = session.createQuery("FROM User").list();
		
		for (User object : results) {
			if (object.getId() == id) {
				return object;
			}
		}
		return null;
	}

}