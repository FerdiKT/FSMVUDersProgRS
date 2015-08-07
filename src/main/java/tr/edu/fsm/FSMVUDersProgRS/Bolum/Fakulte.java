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
 * Fakulte generated by hbm2java
 */
@Entity
@Table(name = "Fakulte", catalog = "sql286097")
public class Fakulte implements java.io.Serializable {

	private Integer id;
	private String fakulteKodu;
	private String fakulteAdi;
	private String yerleskeKodu;

	public Fakulte() {
	}

	public Fakulte(String fakulteKodu, String fakulteAdi, String yerleskeKodu) {
		this.fakulteKodu = fakulteKodu;
		this.fakulteAdi = fakulteAdi;
		this.yerleskeKodu = yerleskeKodu;
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

	@Column(name = "fakulte_kodu", nullable = false, length = 45)
	public String getFakulteKodu() {
		return this.fakulteKodu;
	}

	public void setFakulteKodu(String fakulteKodu) {
		this.fakulteKodu = fakulteKodu;
	}

	@Column(name = "fakulte_adi", nullable = false, length = 45)
	public String getFakulteAdi() {
		return this.fakulteAdi;
	}

	public void setFakulteAdi(String fakulteAdi) {
		this.fakulteAdi = fakulteAdi;
	}

	@Column(name = "yerleske_kodu", nullable = false, length = 45)
	public String getYerleskeKodu() {
		return this.yerleskeKodu;
	}

	public void setYerleskeKodu(String yerleskeKodu) {
		this.yerleskeKodu = yerleskeKodu;
	}

}