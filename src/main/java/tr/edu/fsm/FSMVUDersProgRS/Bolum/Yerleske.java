package tr.edu.fsm.FSMVUDersProgRS.Bolum;
// default package
// Generated 07.A�u.2015 11:35:12 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Yerleske generated by hbm2java
 */
@Entity
@Table(name = "Yerleske", catalog = "sql286097")
public class Yerleske implements java.io.Serializable {

	private Integer id;
	private String yerleskeKodu;
	private String yerleskeAdi;
	private String adres;

	public Yerleske() {
	}

	public Yerleske(String yerleskeKodu, String yerleskeAdi) {
		this.yerleskeKodu = yerleskeKodu;
		this.yerleskeAdi = yerleskeAdi;
	}

	public Yerleske(String yerleskeKodu, String yerleskeAdi, String adres) {
		this.yerleskeKodu = yerleskeKodu;
		this.yerleskeAdi = yerleskeAdi;
		this.adres = adres;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "yerleske_kodu", nullable = false, length = 45)
	public String getYerleskeKodu() {
		return this.yerleskeKodu;
	}

	public void setYerleskeKodu(String yerleskeKodu) {
		this.yerleskeKodu = yerleskeKodu;
	}

	@Column(name = "yerleske_adi", nullable = false, length = 45)
	public String getYerleskeAdi() {
		return this.yerleskeAdi;
	}

	public void setYerleskeAdi(String yerleskeAdi) {
		this.yerleskeAdi = yerleskeAdi;
	}

	@Column(name = "adres", length = 100)
	public String getAdres() {
		return this.adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

}
