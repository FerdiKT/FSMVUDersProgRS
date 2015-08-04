package tr.edu.fsm.FSMVUDersProgRS.Derslik;


import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import tr.edu.fsm.FSMVUDersProgRS.Hibernate.HibernateUtil;

@RestController
public class DerslikDAO {

	static Session session = HibernateUtil.getSessionFactory().openSession();
	
	String json = new String();
	
	Gson gson = new Gson();
	

	//@GET  @PathParam("derslik_kodu") String derslik_kodu
	@RequestMapping("/Derslik")
	public Derslik searchDerslik() throws JsonIOException{
		
		Query query = session.createQuery("from Derslik where derslik_kodu= :derslik_kodu");
		query.setParameter("derslik_kodu", 101);
    	Derslik derslik = new Derslik();
    	
    	derslik = (Derslik) query.list().get(0);
    	json = gson.toJson(derslik);
		
		return derslik;
	}
	
}
