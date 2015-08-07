package tr.edu.fsm.FSMVUDersProgRS.Derslik;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonIOException;

import tr.edu.fsm.FSMVUDersProgRS.Hibernate.HibernateUtil;
import tr.edu.fsm.FSMVUDersProgRS.Derslik.Derslik;
import tr.edu.fsm.FSMVUDersProgRS.Message.Error;
import tr.edu.fsm.FSMVUDersProgRS.Message.Message;
import tr.edu.fsm.FSMVUDersProgRS.Message.Notification;
import tr.edu.fsm.FSMVUDersProgRS.Util.Strings;

@RestController
public class DerslikController {

	static Session session = HibernateUtil.getSessionFactory().openSession();
	Derslik derslik;

	@RequestMapping("/Derslik")
	public Derslik searchDerslik(@RequestParam(value = "derslik_kodu", defaultValue = "101") String derslik_kodu)
			throws JsonIOException {

		Query query = session.createQuery("from Derslik where derslik_kodu= :derslik_kodu");
		query.setParameter("derslik_kodu", derslik_kodu);

		derslik = (Derslik) query.list().get(0);

		return derslik;
	}

	@RequestMapping("/DerslikEkle")
	public Message derslikEkle(@RequestParam(value = "derslikKodu") String derslikKodu,
							@RequestParam(value = "derslikAdi") String derslikAdi,
							@RequestParam(value = "bolumKodu") String bolumKodu)
			throws JsonIOException {
		derslik = Derslik.getInstance();
		Message mesaj;
		try{
			derslik.setAll(derslikKodu, derslikAdi, bolumKodu);
			session.beginTransaction();
			session.save(derslik);
			session.getTransaction().commit();
		}
		catch(JsonIOException e){
			mesaj = new Error();
			mesaj.setDetay(e.getMessage());
			return mesaj;
		}
		mesaj = new Notification();
		mesaj.setDetay(Strings.getStrings("Derslik_ekleme_basarili"));
		return mesaj;
	}

}
