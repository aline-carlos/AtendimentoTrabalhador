package modelo.dao;


import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.MetaPK;
import modelo.Meta;
import modelo.Municipio;


public class MetaDAO extends DaoGenericoImp<Meta, Serializable>{

	
	public Meta salvar(Meta m) {
		return super.atualizar(m);
	}

	public List<Meta> listar() {
		return super.todos();
	}
	
	public Meta consultar(MetaPK pk) {
		return super.pesquisarPorId(pk);
	}
	
	public List<Meta> consultar(Municipio m){
		
		String sqlQuery  = "from Meta " +
							"where municipio = :codmun " +
							"order by id.desde desc" ;
		final Map<String, Object> parameters = new HashMap<String, Object>();
	
		parameters.put("codmun", m.getCodigo());

		return super.listPesqParam(sqlQuery, parameters);
		
	}
	
	public Meta consultarAtual(Municipio m){
		
		String sqlQuery  = "from Meta " +
							"where municipio = :codmun  " +
							"  and ate is null" ;
		final Map<String, Object> parameters = new HashMap<String, Object>();
	
		parameters.put("codmun", m.getCodigo());
		
		return super.pesqParam(sqlQuery, parameters);

		
	}
}
