package modelo.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Agencia;
import modelo.Municipio;

public class AgenciaDAO extends DaoGenericoImp<Agencia, Serializable> {
	public void gravar(Agencia a) {
		super.salvar(a);
	}

	public Agencia consultar(int codigo) {
		return super.pesquisarPorId(codigo);
	}
	
	public List<Agencia> listar() {
		return super.todos();
	}
	
	public List<Agencia> listarAtivas() {
		String sqlQuery  = "from Agencia where ativa = true " ;
		return  super.listPesq(sqlQuery);
		
	}
	public List<Agencia> agenciasMunicipio(Municipio m) {
		String sqlQuery  = "from Agencia " +
				           "where ativa = true " +
				           "and  municipio = :municipio" ;
		
		final Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("municipio", m);
		
		return  super.listPesqParam(sqlQuery, parameters);
		
		
	}
	
	


}
