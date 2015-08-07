package tr.edu.fsm.FSMVUDersProgRS.Ogrenci;
// default package
// Generated 07.A�u.2015 11:35:12 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DonemOgrenci generated by hbm2java
 */
@Entity
@Table(name = "Donem_ogrenci", catalog = "sql286097")
public class DonemOgrenci implements java.io.Serializable {

	private Integer id;
	private String donemKodu;
	private String ogrenciKodu;

	public DonemOgrenci() {
	}

	public DonemOgrenci(String donemKodu, String ogrenciKodu) {
		this.donemKodu = donemKodu;
		this.ogrenciKodu = ogrenciKodu;
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

	@Column(name = "donem_kodu", nullable = false, length = 45)
	public String getDonemKodu() {
		return this.donemKodu;
	}

	public void setDonemKodu(String donemKodu) {
		this.donemKodu = donemKodu;
	}

	@Column(name = "ogrenci_kodu", nullable = false, length = 45)
	public String getOgrenciKodu() {
		return this.ogrenciKodu;
	}

	public void setOgrenciKodu(String ogrenciKodu) {
		this.ogrenciKodu = ogrenciKodu;
	}

}