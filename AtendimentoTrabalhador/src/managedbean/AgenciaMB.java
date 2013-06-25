package managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import modelo.Agencia;
import modelo.dao.AgenciaDAO;

@ManagedBean(name="agenciaMB")
@SessionScoped
public class AgenciaMB implements Serializable {
	
	private static final long serialVersionUID = -8960755229489116499L;

	private Agencia agencia = new Agencia();
	private AgenciaDAO dao = new AgenciaDAO();
	private List<Agencia> lista = new ArrayList<Agencia>();
	private List<Agencia> listaAtivas = new ArrayList<Agencia>();
	private int agenciaSelecionada = 0;
	
	public AgenciaMB() {
		
	}

	public void atualizar() {
		dao.gravar(agencia);
	}
	
	public void consultar() {
		agencia = dao.consultar(agencia.getCodigo());
	}
	
	public String getConsultar() {
		System.out.println("entrou no getconsultar");
		consultar();
		return null;
	}

	public AgenciaDAO getDao() {
		return dao;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public List<Agencia> getLista() {
		lista = dao.listar();
		return lista;
	}

	public void salvar() {
		dao.gravar(agencia);
	}

	public void setDao(AgenciaDAO dao) {
		this.dao = dao;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	
	public void setLista(List<Agencia> lista) {
		this.lista = lista;
	}

	public int getAgenciaSelecionada() {
		return agenciaSelecionada;
	}

	public void setAgenciaSelecionada(int agenciaSelecionada) {
		System.out.println("entrou no agencia selecionada:"+ agenciaSelecionada);
		this.agenciaSelecionada = agenciaSelecionada;
		this.getAgencia().setCodigo(agenciaSelecionada);
		this.consultar();
	}

	public void paginaAgencia(){
		this.consultar();
		//return "/paginas/agencia";
	}

	public String portoAlegre(){
		System.out.println("entrou em POA");
		this.getAgencia().setCodigo(81);
		this.consultar();
		return "/paginas/agencia";
	}

	public List<Agencia> getListaAtivas() {
		listaAtivas = dao.listarAtivas();
		return listaAtivas;
	}

	public void setListaAtivas(List<Agencia> listaAtivas) {
		this.listaAtivas = listaAtivas;
	}

}
