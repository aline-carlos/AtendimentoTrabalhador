package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="caged",schema="servicos")
public class Caged implements Serializable{

	private static final long serialVersionUID = -5497692378315917946L;

	@EmbeddedId
	private CagedPK id;
	
	@ManyToOne
	@JoinColumn(name="municipio", insertable=false, updatable=false)
	private Municipio municipio	;
	
	private Long admitidos;
	
	private String usuario;
	
	private Date dtmodificacao;

	public CagedPK getId() {
		return id;
	}

	public void setId(CagedPK id) {
		this.id = id;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Long getAdmitidos() {
		return admitidos;
	}

	public void setAdmitidos(Long admitidos) {
		this.admitidos = admitidos;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((admitidos == null) ? 0 : admitidos.hashCode());
		result = prime * result
				+ ((dtmodificacao == null) ? 0 : dtmodificacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((municipio == null) ? 0 : municipio.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Caged other = (Caged) obj;
		if (admitidos == null) {
			if (other.admitidos != null)
				return false;
		} else if (!admitidos.equals(other.admitidos))
			return false;
		if (dtmodificacao == null) {
			if (other.dtmodificacao != null)
				return false;
		} else if (!dtmodificacao.equals(other.dtmodificacao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (municipio == null) {
			if (other.municipio != null)
				return false;
		} else if (!municipio.equals(other.municipio))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Caged [id=" + id + ", municipio=" + municipio + ", admitidos="
				+ admitidos + ", usuario=" + usuario + ", dtmodificacao="
				+ dtmodificacao + "]";
	}

	
}
