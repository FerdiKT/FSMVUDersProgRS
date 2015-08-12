package tr.edu.fsm.FSMVUDersProgRS.Derslik;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import tr.edu.fsm.FSMVUDersProgRS.DataAccess.DAOInterface;
import tr.edu.fsm.FSMVUDersProgRS.Hibernate.HibernateDao;
import tr.edu.fsm.FSMVUDersProgRS.Hibernate.HibernateUtil;

public class DerslikDAO<T> extends HibernateDao<T>implements DAOInterface<T> {

	public DerslikDAO(Class<T> cls) {
		super(cls);
	}

//	static Session session = HibernateUtil.getSessionFactory().openSession();
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Derslik> findByParameters(Derslik derslik) {
////		String q;
////		if(derslik.getId() != null){
////			q = "Id" + derslik.getId();
////		}
//		
//		return session.createCriteria(Derslik.class).add(Example.create(derslik)).list();
//		
////		Query query = session.createQuery("from Derslik where derslik_kodu = :derslik_kodu");
////		query.setParameter("derslik_kodu", derslik.getDerslikKodu());
////		return query.list();
//	}
}
