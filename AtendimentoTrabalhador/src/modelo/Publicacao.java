package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="publicacao",schema="servicos")
public class Publicacao implements Serializable{
	
	private static final long serialVersionUID = -2612174030614349373L;

	@Id
	private Integer periodo;
	
	private boolean intermediacao=false;
	
	private boolean caged=false;
		
	private boolean segurodesemprego=false;
	
	private boolean ctps=false;
	
	private String usuario;
	
	private Date dtmodificacao;

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public boolean isIntermediacao() {
		return intermediacao;
	}

	public void setIntermediacao(boolean intermediacao) {
		this.intermediacao = intermediacao;
	}

	public boolean isCaged() {
		return caged;
	}

	public void setCaged(boolean caged) {
		this.caged = caged;
	}

	public boolean isSegurodesemprego() {
		return segurodesemprego;
	}

	public void setSegurodesemprego(boolean segurodesemprego) {
		this.segurodesemprego = segurodesemprego;
	}

	public boolean isCtps() {
		return ctps;
	}

	public void setCtps(boolean ctps) {
		this.ctps = ctps;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getDtmodificacao() {
		return dtmodificacao;
	}

	public void setDtmodificacao(Date dtmodificacao) {
		this.dtmodificacao = dtmodificacao;
	}

	public Publicacao() {
	}
	
	public Publicacao(Integer periodo) {
		this.periodo = periodo;
	}

	@Override
	public String toString() {
		return "Publicacao [periodo=" + periodo + ", intermediacao="
				+ intermediacao + ", caged=" + caged + ", segurodesemprego="
				+ segurodesemprego + ", ctps=" + ctps + ", usuario=" + usuario
				+ ", dtmodificacao=" + dtmodificacao + "]";
	}

	
}
