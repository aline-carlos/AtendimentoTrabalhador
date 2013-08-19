package modelo.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import util.ControleSenha;

import modelo.Usuario;


public class UsuarioDAO  extends DaoGenericoImp<Usuario, Serializable> {		
	
	public Usuario validarCript(Usuario usuario) {
		
		String sqlQuery  = "from Usuario " +
							"where login = :login" +
							" and  senha2 = :senha" ;
		
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("login", usuario.getLogin());
		parameters.put("senha", ControleSenha.codificaSenha(usuario));
		
		
		return super.pesqParam(sqlQuery, parameters);
		
	}
	
	public Usuario inserir(Usuario usuario) {
		
		if (usuario !=null){
			 byte[] senha2 =ControleSenha.codificaSenha(usuario);
			 usuario.setSenha2(senha2);
		}
		super.atualizar(usuario);
		return usuario;

	}
}
