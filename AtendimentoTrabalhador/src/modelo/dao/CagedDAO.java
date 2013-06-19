package modelo.dao;

import java.io.Serializable;

import modelo.Caged;
import modelo.CagedPK;

public class CagedDAO extends DaoGenericoImp<Caged, Serializable> {
	
	public void gravar(Caged c){
		super.atualizar(c);
	}

	public Caged consultar(CagedPK pk) {
		return super.pesquisarPorId(pk);
	}
}
