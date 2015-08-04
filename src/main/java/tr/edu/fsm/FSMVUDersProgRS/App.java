package tr.edu.fsm.FSMVUDersProgRS;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.Gson;

import tr.edu.fsm.FSMVUDersProgRS.Derslik.Derslik;
import tr.edu.fsm.FSMVUDersProgRS.Hibernate.HibernateUtil;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {
	
	static Session session = HibernateUtil.getSessionFactory().openSession();
	
    public static void main( String[] args ){
    	SpringApplication.run(App.class, args);
    	Query query = session.createQuery("from Derslik where Id=4");

    	Derslik derslik = new Derslik();
    	
    	derslik = (Derslik) query.list().get(0);
    	Gson gson = new Gson();
    	String json = new String();
    	
    	json = gson.toJson(derslik);
        System.out.println( json);
    }
}
