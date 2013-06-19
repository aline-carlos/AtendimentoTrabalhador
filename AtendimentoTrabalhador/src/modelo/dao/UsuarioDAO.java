package modelo.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import modelo.Usuario;


public class UsuarioDAO  extends DaoGenericoImp<Usuario, Serializable> {		
	
	public Usuario validar(Usuario usuario) {
		
		
		String sqlQuery  = "from Usuario " +
							"where login = :login" +
							" and  senha = :senha" ;
		
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("login", usuario.getLogin());
		parameters.put("senha", usuario.getSenha());
	
	
		return super.pesqParam(sqlQuery, parameters);

	}
}
