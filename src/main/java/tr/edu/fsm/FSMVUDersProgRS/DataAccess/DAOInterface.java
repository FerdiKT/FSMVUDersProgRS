package tr.edu.fsm.FSMVUDersProgRS.DataAccess;

import java.util.List;

import tr.edu.fsm.FSMVUDersProgRS.Message.Message;

public interface DAOInterface <T> {

	public Message persist(T entity);

	public Message update(T entity);

	public List<T> findByParameters(T param);

	public Message delete(T entity);

	public List<T> findAll();

	public Message deleteAll();
}
