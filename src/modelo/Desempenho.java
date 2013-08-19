package modelo;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="desempenho",schema="servicos")
public class Desempenho implements Serializable {
	
	private static final long serialVersionUID = -8635999218844193202L;

	@EmbeddedId
	private DesempenhoPK id;
	
	@ManyToOne
	@JoinColumn(name="agencia", insertable=false, updatable=false)
	private Agencia agencia;
	
	private Long vagas;
	
	private Long inscritos;
	
	private Long encaminhados;
	
	private Long colocados;
	
	private Long segurodesemprego;
	
	private Long ctps;
	
	private String usuario;
	
	private Date dtmodificacao;
	
	@Transient
	private String mes;

	@Transient
	private String mesabrev;

	public DesempenhoPK getId() {
		return id;
	}

	public void setId(DesempenhoPK id) {
		this.id = id;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Long getVagas() {
		return vagas;
	}

	public void setVagas(Long vagas) {
		this.vagas = vagas;
	}

	public Long getInscritos() {
		return inscritos;
	}

	public void setInscritos(Long inscritos) {
		this.inscritos = inscritos;
	}

	public Long getEncaminhados() {
		return encaminhados;
	}

	public void setEncaminhados(Long encaminhados) {
		this.encaminhados = encaminhados;
	}

	public Long getColocados() {
		return colocados;
	}

	public void setColocados(Long colocados) {
		this.colocados = colocados;
	}

	public Long getSegurodesemprego() {
		return segurodesemprego;
	}

	public void setSegurodesemprego(Long segurodesemprego) {
		this.segurodesemprego = segurodesemprego;
	}

	public Long getCtps() {
		return ctps;
	}

	public void setCtps(Long ctps) {
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

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getMesabrev() {
		return mesabrev;
	}

	public void setMesabrev(String mesabrev) {
		this.mesabrev = mesabrev;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result
				+ ((colocados == null) ? 0 : colocados.hashCode());
		result = prime * result + ((ctps == null) ? 0 : ctps.hashCode());
		result = prime * result
				+ ((dtmodificacao == null) ? 0 : dtmodificacao.hashCode());
		result = prime * result
				+ ((encaminhados == null) ? 0 : encaminhados.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((inscritos == null) ? 0 : inscritos.hashCode());
		result = prime * result + ((mes == null) ? 0 : mes.hashCode());
		result = prime * result
				+ ((mesabrev == null) ? 0 : mesabrev.hashCode());
		result = prime
				* result
				+ ((segurodesemprego == null) ? 0 : segurodesemprego.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((vagas == null) ? 0 : vagas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Desempenho other = (Desempenho) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (colocados == null) {
			if (other.colocados != null)
				return false;
		} else if (!colocados.equals(other.colocados))
			return false;
		if (ctps == null) {
			if (other.ctps != null)
				return false;
		} else if (!ctps.equals(other.ctps))
			return false;
		if (dtmodificacao == null) {
			if (other.dtmodificacao != null)
				return false;
		} else if (!dtmodificacao.equals(other.dtmodificacao))
			return false;
		if (encaminhados == null) {
			if (other.encaminhados != null)
				return false;
		} else if (!encaminhados.equals(other.encaminhados))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inscritos == null) {
			if (other.inscritos != null)
				return false;
		} else if (!inscritos.equals(other.inscritos))
			return false;
		if (mes == null) {
			if (other.mes != null)
				return false;
		} else if (!mes.equals(other.mes))
			return false;
		if (mesabrev == null) {
			if (other.mesabrev != null)
				return false;
		} else if (!mesabrev.equals(other.mesabrev))
			return false;
		if (segurodesemprego == null) {
			if (other.segurodesemprego != null)
				return false;
		} else if (!segurodesemprego.equals(other.segurodesemprego))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (vagas == null) {
			if (other.vagas != null)
				return false;
		} else if (!vagas.equals(other.vagas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Desempenho [id=" + id + ", agencia=" + agencia + ", vagas="
				+ vagas + ", inscritos=" + inscritos + ", encaminhados="
				+ encaminhados + ", colocados=" + colocados
				+ ", segurodesemprego=" + segurodesemprego + ", ctps=" + ctps
				+ ", usuario=" + usuario + ", dtmodificacao=" + dtmodificacao
				+ ", mes=" + mes + ", mesabrev=" + mesabrev + "]";
	}



}
