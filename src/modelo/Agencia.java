package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="agencia",schema="servicos")
public class Agencia implements Serializable{
	
	private static final long serialVersionUID = 1011069878131299782L;

	@Id
	@GeneratedValue
	private int codigo;
	
	@Column(unique=true, length = 50)
	private String nome;
	
	@Column(length = 15)
	private String tipo;

	@Column(length = 100)
	private String endereco;

	@Column(length = 20)
	private String telefone;
	
	@Column(length = 50)
	private String email;

	@Column(length = 500)
	private String infadicionais;

	@ManyToOne(targetEntity=Municipio.class )
	@JoinColumn(name="municipio")
	private Municipio municipio;
	
	private boolean ativa;
	
	@OneToMany(mappedBy="agencia", fetch = FetchType.LAZY)
	private List<Desempenho> desempenhos;

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}
	
	public List<Desempenho> getDesempenhos() {
		return desempenhos;
	}

	public void setDesempenhos(List<Desempenho> desempenhos) {
		this.desempenhos = desempenhos;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInfadicionais() {
		return infadicionais;
	}

	public void setInfadicionais(String infadicionais) {
		this.infadicionais = infadicionais;
	}

	@Override
	public String toString() {
		return "Agencia [codigo=" + codigo + ", nome=" + nome + ", tipo="
				+ tipo + ", endereco=" + endereco + ", telefone=" + telefone
				+ ", email=" + email + ", infadicionais=" + infadicionais
				+ ", municipio=" + municipio + ", ativa=" + ativa
				+ ", desempenhos=" + desempenhos + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ativa ? 1231 : 1237);
		result = prime * result + codigo;
		result = prime * result
				+ ((desempenhos == null) ? 0 : desempenhos.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result
				+ ((infadicionais == null) ? 0 : infadicionais.hashCode());
		result = prime * result
				+ ((municipio == null) ? 0 : municipio.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Agencia other = (Agencia) obj;
		if (ativa != other.ativa)
			return false;
		if (codigo != other.codigo)
			return false;
		if (desempenhos == null) {
			if (other.desempenhos != null)
				return false;
		} else if (!desempenhos.equals(other.desempenhos))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (infadicionais == null) {
			if (other.infadicionais != null)
				return false;
		} else if (!infadicionais.equals(other.infadicionais))
			return false;
		if (municipio == null) {
			if (other.municipio != null)
				return false;
		} else if (!municipio.equals(other.municipio))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}


}
