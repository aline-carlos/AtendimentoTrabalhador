package managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import modelo.Regional;
import modelo.dao.RegionalDAO;


@ManagedBean(name="regionalMB") 
@SessionScoped
public class RegionalMB implements Serializable {
	
	private static final long serialVersionUID = -2967654761580180578L;
	
	private Regional regional = new Regional();
	private RegionalDAO dao = new RegionalDAO();
	private List<Regional> lista = new ArrayList<Regional>();	
	
	public RegionalMB() {
		
	}

	public Regional getRegional() {
		return regional;
	}

	public void setRegional(Regional regional) {
		this.regional = regional;
	}

	public RegionalDAO getDao() {
		return dao;
	}

	public void setDao(RegionalDAO dao) {
		this.dao = dao;
	}

	public List<Regional> getLista() {
		lista = dao.listar();		
		return lista;		
	}

	public void setLista(List<Regional> lista) {
		this.lista = lista;
	}
	
	

		
	

	
}
