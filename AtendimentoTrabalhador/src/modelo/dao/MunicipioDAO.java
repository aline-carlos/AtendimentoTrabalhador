package modelo.dao;


import java.io.Serializable;
import java.util.List;

import modelo.Municipio;

public class MunicipioDAO extends DaoGenericoImp<Municipio, Serializable> {
	
	public Municipio gravar(Municipio m) {
		return super.atualizar(m);
	}

	public Municipio consultar(int codigo) {
		return super.pesquisarPorId(codigo);
	}
	
	public List<Municipio> listar() {
		return super.todos();
	}
	
}
