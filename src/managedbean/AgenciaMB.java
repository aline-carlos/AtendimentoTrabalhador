package managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import modelo.Agencia;
import modelo.Municipio;
import modelo.dao.AgenciaDAO;
import modelo.dao.MunicipioDAO;

@ManagedBean(name="agenciaMB")
@SessionScoped
public class AgenciaMB implements Serializable {
	
	private static final long serialVersionUID = -8960755229489116499L;

	private Agencia agencia = new Agencia();
	private AgenciaDAO dao = new AgenciaDAO();
	private List<Agencia> lista = new ArrayList<Agencia>();
	private List<Agencia> listaAtivas = new ArrayList<Agencia>();
	private List<Agencia> agenciasMunicipio = new ArrayList<Agencia>();
	private int agenciaSelecionada = 0;
	private int municipioSelecionado = 0;
	private int teste = 0;
	
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
		
		this.agenciaSelecionada = agenciaSelecionada;
		this.selecionarAgencia();
	}

	public void selecionarAgencia() {
		System.out.println("entrou no agencia selecionada..." + this.getAgenciaSelecionada());
		this.getAgencia().setCodigo(agenciaSelecionada);
		this.consultar();
	}
	
	public void paginaAgencia(){
		this.consultar();

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

	public int getMunicipioSelecionado() {
		return municipioSelecionado;
	}

	public void setMunicipioSelecionado(int municipioSelecionado) {
		this.municipioSelecionado = municipioSelecionado;
		Municipio m = new Municipio();
		MunicipioDAO mDAO = new MunicipioDAO();
		m = mDAO.consultar(municipioSelecionado);
		System.out.println(m.toString());
		agenciasMunicipio = dao.agenciasMunicipio(m);
		//System.out.println(agenciasMunicipio.toString());
	}

	public List<Agencia> getAgenciasMunicipio() {
		return agenciasMunicipio;
	}

	public void setAgenciasMunicipio(List<Agencia> agenciasMunicipio) {
		this.agenciasMunicipio = agenciasMunicipio;
	}

	public int getTeste() {
		return teste;
	}

	public void setTeste(int teste) {
		this.teste = teste;
	}

}
