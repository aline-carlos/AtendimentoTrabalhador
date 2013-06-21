package modelo.dao;

import java.io.Serializable;
import java.util.List;

import modelo.Regional;

public class RegionalDAO extends DaoGenericoImp<Regional, Serializable>{
	
	public Regional atualizar(Regional r) {
		return super.atualizar(r);
	}

	public Regional consultar(int codigo) {
		return super.pesquisarPorId(codigo);
	}
	
	public List<Regional> listar() {
		return super.todos();
	}
	
	public List<Regional> listarAtivas() {
		String sqlQuery  = "from Regional where ativa = true " ;
		return super.listPesq(sqlQuery);
		
	}	

}
