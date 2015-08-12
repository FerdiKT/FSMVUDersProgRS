package tr.edu.fsm.FSMVUDersProgRS.Message;

/*
 * Bu interface client a mesaj göndermek için oluşturuldu.
 * error, notificatoin ve warning de bu interface i implement etmiştir.
 */
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
