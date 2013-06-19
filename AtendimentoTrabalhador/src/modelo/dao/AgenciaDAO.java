package modelo.dao;

import java.io.Serializable;
import java.util.List;

import modelo.Agencia;

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
	
	


}
