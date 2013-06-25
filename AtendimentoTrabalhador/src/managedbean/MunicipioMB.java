package managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import modelo.Municipio;
import modelo.dao.MunicipioDAO;

@ManagedBean(name="municipioMB")
public class MunicipioMB implements Serializable{

	private static final long serialVersionUID = -8946676903538996212L;
	

	private Municipio municipio = new Municipio();
	private MunicipioDAO dao = new MunicipioDAO();
	private List<Municipio> lista = new ArrayList<Municipio>();
	private List<Municipio> listaAtivos = new ArrayList<Municipio>();

	public MunicipioMB() {
		lista = dao.listar();
	}

	public void atualizar() {
		dao.gravar(municipio);
	}
	
	public void consultar() {
		dao.consultar(municipio.getCodigo());
	}

	public MunicipioDAO getDao() {
		return dao;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public List<Municipio> getLista() {
		return lista;
	}

	public void salvar() {
		dao.gravar(municipio);
	}

	public void setDao(MunicipioDAO dao) {
		this.dao = dao;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	
	public void setLista(List<Municipio> lista) {
		this.lista = lista;
	}

	public List<Municipio> getListaAtivos() {
		listaAtivos = dao.listarAtivos();
		return listaAtivos;
	}

	public void setListaAtivos(List<Municipio> listaAtivos) {
		this.listaAtivos = listaAtivos;
	}



}
