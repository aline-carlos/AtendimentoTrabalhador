package modelo.dao;


import java.io.Serializable;

import modelo.Publicacao;


public class PublicacaoDAO extends DaoGenericoImp<Publicacao, Serializable> {
	
	public void gravar(Publicacao p) {
		super.atualizar(p);
	}
	
	public Publicacao consultar(int pk) {
		return super.pesquisarPorId(pk);
	}
	
}
