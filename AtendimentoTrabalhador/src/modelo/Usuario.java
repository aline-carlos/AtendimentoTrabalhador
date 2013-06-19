package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario",schema="servicos")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 4120132089354624347L;

	@Id	
	private String login;
	
	@Column(length = 60)
	private String nome;
	
	private boolean isadministrador;
	
	private String senha;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isIsadministrador() {
		return isadministrador;
	}

	public void setIsadministrador(boolean isadministrador) {
		this.isadministrador = isadministrador;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario() {
	}

	public Usuario(String login, String nome, boolean isadministrador) {
		this.login = login;
		this.nome = nome;
		this.isadministrador = isadministrador;
	}

	@Override
	public String toString() {
		return "Usuario [login=" + login + ", nome=" + nome
				+ ", isadministrador=" + isadministrador + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isadministrador ? 1231 : 1237);
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Usuario other = (Usuario) obj;
		if (isadministrador != other.isadministrador)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	
	

}
