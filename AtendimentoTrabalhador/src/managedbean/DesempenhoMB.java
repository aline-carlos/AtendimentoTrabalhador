package managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import negocio.ValidaDesempenho;
//import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.SessionScoped;
//import javax.faces.bean.RequestScoped;

import modelo.Agencia;
import modelo.Desempenho;
import modelo.DesempenhoPK;
import modelo.dao.AgenciaDAO;
import modelo.dao.DesempenhoDAO;

@ManagedBean(name="desempenhoMB")
public class DesempenhoMB implements Serializable {

	private static final long serialVersionUID = -2810909712639335546L;

	private Desempenho desempenho = new Desempenho();
	private DesempenhoDAO dao = new DesempenhoDAO();
	private List<Desempenho> lista = new ArrayList<Desempenho>();

	private Integer periodo = 0;
	private Agencia agencia = new Agencia();
	
	private String mensagem = ""; 
	
	//@ManagedProperty("#{usuarioMB.logado}")  
	//private boolean usuarioLogado; 

	public DesempenhoMB() {
	}
	
	public void atualizar() {
		dao.gravar(desempenho);
		listar();
	}
	
	public void listar() {
		lista = dao.listar();
	}
	
	public void salvar() {
		
		ValidaDesempenho validacao = new ValidaDesempenho();
		
		//ctx.addMessage(null, new FacesMessage("O mês informado não é valido."));
		
		DesempenhoPK desempenhoPK = new DesempenhoPK();
		desempenhoPK.setAgencia(this.getAgencia().getCodigo());
		desempenhoPK.setPeriodo(this.periodo);
		desempenho.setId(desempenhoPK);
		if (validacao.validarDados(desempenho)){
			dao.atualizar(desempenho);
		}else
			System.out.println("nao validou");
	}

	public void consultar() {
		
		this.setMensagem("");
		AgenciaDAO daoAgencia = new AgenciaDAO();
		this.setAgencia(daoAgencia.consultar(this.agencia.getCodigo()));
		
		DesempenhoPK desempenhoPK = new DesempenhoPK();
		desempenhoPK.setAgencia(this.getAgencia().getCodigo());
		desempenhoPK.setPeriodo(this.periodo);
		this.setDesempenho(dao.consultar(desempenhoPK));
		//System.out.println(desempenho.toString());
		
	}

	public Desempenho getDesempenho() {
		return desempenho;
	}

	public void setDesempenho(Desempenho desempenho) {
		this.desempenho = desempenho;
	}

	public DesempenhoDAO getDao() {
		return dao;
	}

	public void setDao(DesempenhoDAO dao) {
		this.dao = dao;
	}

	public List<Desempenho> getLista() {
		return lista;
	}

	public void setLista(List<Desempenho> lista) {
		this.lista = lista;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	
}
