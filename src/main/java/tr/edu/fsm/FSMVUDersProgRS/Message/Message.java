package tr.edu.fsm.FSMVUDersProgRS.Message;

public interface Message {
	
	int kod=0;
	MsgType type=MsgType.NOTIFICATION;
	String detay="";
	
	public int getKod();
	public void setKod(int kod);
	public MsgType getType();
	public void setType(MsgType type);
	public String getDetay();
	public void setDetay(String detay);
}
