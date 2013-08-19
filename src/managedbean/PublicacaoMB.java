package managedbean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;

import util.AcessoUtil;

import modelo.Publicacao;
import modelo.dao.PublicacaoDAO;

@ManagedBean(name="publicacaoMB")
public class PublicacaoMB implements Serializable{

	private static final long serialVersionUID = -5302619102853781159L;
	
	private Publicacao publicacao= new Publicacao();
	
	private PublicacaoDAO dao = new PublicacaoDAO();
	
	private String mensagem = "";
	
	public void consultar() {
		Publicacao publ;
		this.setMensagem("");
		
		publ = dao.consultar(publicacao.getPeriodo());
		if ( publ == null ){
			publ = new Publicacao();
			publ.setPeriodo(publicacao.getPeriodo());
			this.setPublicacao(publ);
		}else
			this.setPublicacao(publ);
	}
	
	public void salvar() {
		publicacao.setDtmodificacao(new Date());
		publicacao.setUsuario(AcessoUtil.userLogged());
		dao.gravar(publicacao);		
		this.setMensagem("Dados salvos com sucesso.");
	}

	public Publicacao getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}

	public PublicacaoDAO getDao() {
		return dao;
	}

	public void setDao(PublicacaoDAO dao) {
		this.dao = dao;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
