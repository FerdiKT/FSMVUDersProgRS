package tr.edu.fsm.FSMVUDersProgRS.Akademisyen;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonIOException;

import tr.edu.fsm.FSMVUDersProgRS.Controller;
import tr.edu.fsm.FSMVUDersProgRS.IController;
import tr.edu.fsm.FSMVUDersProgRS.DataAccess.DAOFactory;
import tr.edu.fsm.FSMVUDersProgRS.DataAccess.DAOInterface;
import tr.edu.fsm.FSMVUDersProgRS.DataAccess.Dao;
import tr.edu.fsm.FSMVUDersProgRS.Derslik.Derslik;
import tr.edu.fsm.FSMVUDersProgRS.Message.Message;

@RestController
public class AkademisyenController<T> extends Controller<Akademisyen> implements IController<Akademisyen> {
	
	
}
