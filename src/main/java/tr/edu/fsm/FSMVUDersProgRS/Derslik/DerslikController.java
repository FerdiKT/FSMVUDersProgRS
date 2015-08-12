package tr.edu.fsm.FSMVUDersProgRS.Derslik;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hsqldb.lib.HashMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonIOException;

import tr.edu.fsm.FSMVUDersProgRS.Hibernate.HibernateUtil;
import tr.edu.fsm.FSMVUDersProgRS.IController;
import tr.edu.fsm.FSMVUDersProgRS.DataAccess.Dao;
import tr.edu.fsm.FSMVUDersProgRS.DataAccess.DAOFactory;
import tr.edu.fsm.FSMVUDersProgRS.DataAccess.DAOInterface;
import tr.edu.fsm.FSMVUDersProgRS.Derslik.Derslik;
import tr.edu.fsm.FSMVUDersProgRS.Message.Error;
import tr.edu.fsm.FSMVUDersProgRS.Message.Message;
import tr.edu.fsm.FSMVUDersProgRS.Message.Notification;
import tr.edu.fsm.FSMVUDersProgRS.Util.Strings;

@RestController
public class DerslikController implements IController<Derslik>{

	DAOFactory<Derslik> daoFactory = new DAOFactory<>(Derslik.class);
	
	DAOInterface<Derslik> dao = daoFactory.getDAO(Dao.DERSLIK);
	
	/*
	 * RequestMapping için oluşturulmuştur.
	 * cls değeri her class için değiştirilmelidir.
	 */
	final String cls = "Derslik";

	/*
	 * Liste döndürecek olan metotlara mesajda eklenerek
	 * hata veya başarılı tarzında bilgi verilecektir.
	 */
	private Map<Message,List<Derslik>> map;
	
	/*
	 * Döndürülecek mesaj için oluşturulan Message objesi
	 */
	Message msg;
	
	/*
	 * Liste döndürmesi gereken Hibernate metotlarından hata gelirse
	 * bu boş liste döndürülecektir.
	 */
	List<Derslik> list;
	
	/*
	 * URL ile gelen veri dao objesi ile HibernateDao classına gönderiliyor.
	 */
	@Override
	@RequestMapping("/" + cls + "Ekle")
	public Message persist(Derslik entity) {
		try{
			return dao.persist(entity);
		}catch (HibernateException e){
			msg = new Error();
			msg.setDetay(Strings.getStrings("an_error_occurred_while_saving")
					+ e.getMessage());
			msg.setKod(1001);
			return msg;
		}
	}
	
	/*
	 * URL ile gelen veri dao objesi ile HibernateDao classına gönderiliyor.
	 */
	@Override
	@RequestMapping("/"+cls+"Duzenle")
	public Message update(Derslik entity) {
		return dao.update(entity);
	}
	
	/*
	 * URL ile gelen veri dao objesi ile HibernateDao class'ına gönderiliyor.
	 * Dönen değere göre client'a veri gönderilecek.
	 */
	@Override
	@RequestMapping("/"+cls+"Ara")
	public Map<Message,List<Derslik>> findByParameters(@ModelAttribute(cls)Derslik derslik) throws JsonIOException {
		map.put(new Notification(), dao.findByParameters(derslik));
		return map;
	}
	
	/*
	 * URL ile gelen veri dao objesi ile HibernateDao classına gönderiliyor.
	 */
	@Override
	@RequestMapping("/"+cls+"Sil")
	public Message delete(Derslik entity) {
		try{
			return dao.delete(entity);
		}catch (HibernateException e){
			msg = new Error();
			msg.setDetay(Strings.getStrings("an_error_occurred_while_deleting")
					+ e.getMessage());
			msg.setKod(1004);
			return msg;
		}
	}
	
	/*
	 * URL ile gelen veri dao objesi ile HibernateDao class'ına gönderiliyor.
	 * Dönen değere göre client'a veri gönderilecek.
	 */
	@Override
	public Map<Message,List<Derslik>> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * URL ile gelen veri dao objesi ile HibernateDao classına gönderiliyor.
	 */
	@Override
	public Message deleteAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
//
//	@RequestMapping("/Derslik")
//	public Derslik searchDerslik(@RequestParam(value = "derslik_kodu", defaultValue = "101") String derslik_kodu)
//			throws JsonIOException {
//
//		Query query = session.createQuery("from Derslik where derslik_kodu= :derslik_kodu");
//		query.setParameter("derslik_kodu", derslik_kodu);
//
//		derslik = (Derslik) query.list().get(0);
//
//		return derslik;
//	}
//
//	@RequestMapping("/DerslikEkle")
//	public Message derslikEkle(@RequestParam(value = "derslikKodu") String derslikKodu,
//							@RequestParam(value = "derslikAdi") String derslikAdi,
//							@RequestParam(value = "bolumKodu") String bolumKodu)
//			throws JsonIOException {
//		derslik = Derslik.getInstance();
//		Message mesaj;
//		try{
//			derslik.setAll(derslikKodu, derslikAdi, bolumKodu);
//			session.beginTransaction();
//			session.save(derslik);
//			session.getTransaction().commit();
//		}
//		catch(JsonIOException e){
//			mesaj = new Error();
//			mesaj.setDetay(e.getMessage());
//			return mesaj;
//		}
//		mesaj = new Notification();
//		mesaj.setDetay(Strings.getStrings("Derslik_ekleme_basarili"));
//		return mesaj;
//	}

}
