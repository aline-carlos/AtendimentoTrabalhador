package managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import modelo.Meta;
import modelo.MetaPK;
//import modelo.MetaPK;
import modelo.Municipio;
import modelo.dao.MetaDAO;

@ManagedBean(name="metaMB")
public class MetaMB implements Serializable{

	private static final long serialVersionUID = -3048246748173844118L;
	
	private Meta meta = new Meta();
	private MetaDAO dao = new MetaDAO();
	
	private List<Meta> lista = new ArrayList<Meta>();	
	private Municipio municipio = new Municipio();
	private Date desde;
	
	
	public MetaMB() {
	}

	public void consultar(){
		this.setLista(dao.consultar(municipio));
	
	}
	
	public void salvar(){
		System.out.println("entrou:" + desde);
		Meta metaAnterior = new Meta();
		metaAnterior = dao.consultarAtual(getMunicipio());
		Calendar dataAnterior = Calendar.getInstance();
		dataAnterior.setTime(desde);
		dataAnterior.add(Calendar.DAY_OF_MONTH, -1);
		metaAnterior.setAte(dataAnterior.getTime());
		
		
		MetaPK pk = new MetaPK();
		pk.setMunicipio(municipio.getCodigo());
		pk.setDesde(desde);
		meta.setId(pk);
		
		dao.atualizar(metaAnterior);
		dao.atualizar(meta);
		
		this.setLista(dao.consultar(municipio));
		this.setDesde(null);
		this.setMeta(new Meta());
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public MetaDAO getDao() {
		return dao;
	}

	public void setDao(MetaDAO dao) {
		this.dao = dao;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Date getDesde() {
		return desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public List<Meta> getLista() {
		return lista;
	}

	public void setLista(List<Meta> lista) {
		this.lista = lista;
	}
	/*
	public void onEdit(RowEditEvent event) {  
		//FacesMessage msg = new FacesMessage("Meta Editada", ((Meta) event.getObject()));  
	  
		//FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("entrou no on edit");
		Meta teste;
		teste = (Meta) event.getObject();
		System.out.println(teste.toString());
		this.setMeta((Meta) event.getObject());
		//this.salvar();
		dao.atualizar(teste);
		System.out.println("salvou?");
		
	}  
	      
	public void onCancel(RowEditEvent event) {  
		System.out.println("entrou no cancel");
		//FacesMessage msg = new FacesMessage("Meta Cancelada", ((Meta) event.getObject()).getModel());  
	  
	//	FacesContext.getCurrentInstance().addMessage(null, msg);  
	}  	
	*/
}
