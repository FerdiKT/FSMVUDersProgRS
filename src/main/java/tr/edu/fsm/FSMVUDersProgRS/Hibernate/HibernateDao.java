package tr.edu.fsm.FSMVUDersProgRS.Hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import com.google.gson.JsonIOException;

import tr.edu.fsm.FSMVUDersProgRS.DataAccess.DAOInterface;
import tr.edu.fsm.FSMVUDersProgRS.Derslik.Derslik;
import tr.edu.fsm.FSMVUDersProgRS.Message.Error;
import tr.edu.fsm.FSMVUDersProgRS.Message.Message;
import tr.edu.fsm.FSMVUDersProgRS.Message.Notification;
import tr.edu.fsm.FSMVUDersProgRS.Util.Strings;

public class HibernateDao<T> implements DAOInterface<T> {
	

	static Session session = HibernateUtil.getSessionFactory().openSession();

	/*
	 * Döndürülecek mesaj için oluşturulan Message objesi
	 */
	Message msj;
	
	private Class<T> type;
    public HibernateDao(Class<T> cls){
       type= cls;
    }
    
    private Class<T> getType(){
    	return type;
    }
    
	@Override
	public Message persist(T entity) {
		try {
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
		} catch (JsonIOException e) {
			msj = new Error();
			msj.setDetay(e.getMessage());
			return msj;
		}
		msj = new Notification();
		msj.setDetay(entity.getClass() + Strings.getStrings("ekleme_basarili"));
		return msj;
	}

	@Override
	public Message update(T entity) {
		try {
			session.beginTransaction();
			session.update(entity);
			session.getTransaction().commit();
		} catch (JsonIOException e) {
			msj = new Error();
			msj.setDetay(e.getMessage());
			return msj;
		}
		msj = new Notification();
		msj.setDetay(entity.getClass().getName() + Strings.getStrings("ekleme_basarili"));
		return msj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByParameters(T param) {

//		Query query = session.createQuery("from Derslik where derslik_kodu= :derslik_kodu");
//		query.setParameter("derslik_kodu", ((Derslik) param).getDerslikKodu());
//
//		return query.list();
		
		return session.createCriteria(getType()).add(Example.create(param)).list();
		
	}

	@Override
	public Message delete(T entity) {
		try {
			session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();
		} catch (JsonIOException e) {
			msj = new Error();
			msj.setDetay(e.getMessage());
			return msj;
		}
		msj = new Notification();
		msj.setDetay(entity.getClass() + Strings.getStrings("silme_basarili"));
		return msj;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message deleteAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
