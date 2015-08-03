package tr.edu.fsm.FSMVUDersProgRS;

import org.hibernate.Query;
import org.hibernate.Session;

import tr.edu.fsm.FSMVUDersProgRS.Derslik.Derslik;
import tr.edu.fsm.FSMVUDersProgRS.Hibernate.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App {
	
	static Session session = HibernateUtil.getSessionFactory().openSession();
	
    public static void main( String[] args ){
    	
    	Query query = session.createQuery("from Derslik where Id=1");

    	Derslik derslik = new Derslik();
    	
    	derslik = (Derslik) query.list().get(0);
    	
        System.out.println( derslik.getDerslikAdi());
    }
}
