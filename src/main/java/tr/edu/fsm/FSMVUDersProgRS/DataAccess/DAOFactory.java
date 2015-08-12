package tr.edu.fsm.FSMVUDersProgRS.DataAccess;

import tr.edu.fsm.FSMVUDersProgRS.Derslik.DerslikDAO;
import tr.edu.fsm.FSMVUDersProgRS.Hibernate.HibernateDao;

public class DAOFactory<T> {
	
	private DAOInterface<T> daoInterface;
	
	private Class<T> type;

	public DAOFactory (Class<T> cls){
		type = cls;
	}
	
	private Class<T> getType(){
    	return type;
    }
	
	public DAOInterface<T> getDAO(Dao daoType) {

		switch (daoType) {
		case HIBERNATE:
			daoInterface = new HibernateDao<T>(getType());
			break;
		case DERSLIK:
			daoInterface = new DerslikDAO<T>(getType());
			break;
		default:
			daoInterface = new HibernateDao<T>(getType());
			break;
		}

		return daoInterface;
	}
}
