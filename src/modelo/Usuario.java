package modelo;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="usuario",schema="servicos")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 4120132089354624347L;

	@Id	
	private String login;
	
	@Column(length = 60)
	private String nome;
	
	private boolean isadministrador;
	
	@Transient
	private String senha;

	private byte[] senha2;

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

	public byte[] getSenha2() {
		return senha2;
	}

	public void setSenha2(byte[] senha2) {
		this.senha2 = senha2;
	}

	@Override
	public String toString() {
		return "Usuario [login=" + login + ", nome=" + nome
				+ ", isadministrador=" + isadministrador + ", senha2=" + Arrays.toString(senha2) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isadministrador ? 1231 : 1237);
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + Arrays.hashCode(senha2);
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
		if (!Arrays.equals(senha2, other.senha2))
			return false;
		return true;
	}

	
}
