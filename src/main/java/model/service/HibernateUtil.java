package model.service;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration; 

public class HibernateUtil {

	private static SessionFactory sessionFactory;
    
    public HibernateUtil() {
		
	}

	public static SessionFactory getSessionFactory(){
        
            try
            {
                sessionFactory = new Configuration().configure("/model/service/hibernate.cfg.xml").buildSessionFactory();
                System.out.println("Session : "+sessionFactory);
            }catch (Throwable exception){
                System.err.println(exception);
            }
            return sessionFactory;
        
    }
}