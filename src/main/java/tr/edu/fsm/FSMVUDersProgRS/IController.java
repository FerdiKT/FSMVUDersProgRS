package tr.edu.fsm.FSMVUDersProgRS;

import java.util.List;
import java.util.Map;

import tr.edu.fsm.FSMVUDersProgRS.Message.Message;

public interface IController<T> {

	public Message persist(T entity);

	public Message update(T entity);

	public Map<Message,List<T>> findByParameters(T entity);

	public Message delete(T entity);

	public Map<Message,List<T>> findAll();

	public Message deleteAll();

}
