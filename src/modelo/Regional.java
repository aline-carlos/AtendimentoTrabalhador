package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;

@Entity
@Table(name="regional",schema="servicos")
public class Regional implements Serializable{

	private static final long serialVersionUID = 6156426439153654897L;

	@Id
	private int codigo;
	
	@Column(unique=true, length = 40)
	private String nome;
	
	@Column(length = 150)
	private String descricao;
	
	private boolean ativa;
		
	@OneToMany(mappedBy="regional", fetch = FetchType.LAZY)
	private List<Municipio> municipios;


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public Regional() {
		
	}

	public Regional(int codigo, String nome, boolean ativa) {
		this.codigo = codigo;
		this.nome = nome;
		this.ativa = ativa;
	}

	@Override
	public String toString() {
		return "Regional [codigo=" + codigo + ", nome=" + nome + ", ativa="
				+ ativa + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ativa ? 1231 : 1237);
		result = prime * result + codigo;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((municipios == null) ? 0 : municipios.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Regional other = (Regional) obj;
		if (ativa != other.ativa)
			return false;
		if (codigo != other.codigo)
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (municipios == null) {
			if (other.municipios != null)
				return false;
		} else if (!municipios.equals(other.municipios))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	
	
	
	
	
}
