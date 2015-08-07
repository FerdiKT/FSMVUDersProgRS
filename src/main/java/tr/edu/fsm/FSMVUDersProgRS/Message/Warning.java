package tr.edu.fsm.FSMVUDersProgRS.Message;

public class Warning implements Message {

	int kod=1;
	MsgType type=MsgType.WARNING;
	String detay="";
	
	public int getKod() {
		return kod;
	}
	public void setKod(int kod) {
		this.kod = kod;
	}
	public MsgType getType() {
		return type;
	}
	public void setType(MsgType type) {
		this.type = type;
	}
	public String getDetay() {
		return detay;
	}
	public void setDetay(String detay) {
		this.detay = detay;
	}

}
