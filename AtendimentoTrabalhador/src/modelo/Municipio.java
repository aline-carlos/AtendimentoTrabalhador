package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="municipio",schema="servicos")
public class Municipio implements Serializable {
	
	private static final long serialVersionUID = -3143294435440524634L;

	@Id
	private Integer codigo;
	
	@Column(unique=true, length = 40)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="regional", insertable=true, updatable=true)
	private Regional regional;
	
	
	private boolean ativo;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Regional getRegional() {
		return regional;
	}

	public void setRegional(Regional regional) {
		this.regional = regional;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Municipio() {
	
	}

	public Municipio(int codigo, String nome, Regional regional, boolean ativo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.regional = regional;
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Municipio [codigo=" + codigo + ", nome=" + nome + ", regional="
				+ regional + ", ativo=" + ativo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + codigo;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((regional == null) ? 0 : regional.hashCode());
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
		Municipio other = (Municipio) obj;
		if (ativo != other.ativo)
			return false;
		if (codigo != other.codigo)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (regional == null) {
			if (other.regional != null)
				return false;
		} else if (!regional.equals(other.regional))
			return false;
		return true;
	}
	

}
