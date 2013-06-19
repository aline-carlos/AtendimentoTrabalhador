package managedbean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;

import util.AcessoUtil;

import modelo.Caged;
import modelo.CagedPK;
import modelo.Municipio;
import modelo.dao.CagedDAO;

@ManagedBean(name="cagedMB")
public class CagedMB implements Serializable{

	private static final long serialVersionUID = 5773889951509877121L;
	
	private Caged caged = new Caged();
	
	private CagedDAO dao = new CagedDAO();
	
	private Integer periodo = 0;
	private Municipio municipio= new Municipio();

	public void consultar(){
		CagedPK pk = new CagedPK();
		pk.setMunicipio(municipio.getCodigo());
		pk.setPeriodo(periodo);
		this.setCaged(dao.consultar(pk));
	}
	
	public void salvar(){
		
		CagedPK pk = new CagedPK();
		pk.setMunicipio(municipio.getCodigo());
		pk.setPeriodo(periodo);
		caged.setId(pk);
		caged.setDtmodificacao(new Date());
		caged.setUsuario(AcessoUtil.userLogged());
		dao.atualizar(caged);
	}

	public Caged getCaged() {
		return caged;
	}

	public void setCaged(Caged caged) {
		this.caged = caged;
	}

	public CagedDAO getDao() {
		return dao;
	}

	public void setDao(CagedDAO dao) {
		this.dao = dao;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	
	

}
