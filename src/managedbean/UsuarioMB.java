package managedbean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import util.AcessoUtil;
import modelo.Usuario;
import modelo.dao.UsuarioDAO;

@ManagedBean(name="usuarioMB")
public class UsuarioMB implements Serializable{

	private static final long serialVersionUID = -4350207791581637099L;

	private Usuario usuario;
	private Usuario novoUsuario;
	private String mensagem = ""; 
	private String senha ="";
	private boolean logado = false;
	
	private UsuarioDAO usuarioDao ;
 
	public UsuarioMB() {
		usuario = new Usuario();
		usuarioDao = new UsuarioDAO();
		novoUsuario = new Usuario();

	}

	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}


	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}


	private List<Usuario> lista = new ArrayList<Usuario>();


	public String autenticar()  {

		String viewId = "login";
		usuario = getUsuarioDao().validarCript(usuario);
		if (usuario!=null) {
			setLogado(true);
			viewId = AcessoUtil.logIn("/paginas/adm/exibeDesempenho", usuario.getLogin());
		
		}else {
			this.setMensagem("Usuário e/ou senha inválidos!");
			setLogado(false);
			viewId = "";
		}
		return viewId;
	}

	public boolean isLoggedIn() {

        return AcessoUtil.isLoggedIn();
    }
	
	public void consultar(){
		usuario = getUsuarioDao().pesquisarPorId(usuario.getLogin());
	}
	
	public void incluir(){
		usuarioDao.inserir(novoUsuario);
		novoUsuario = new Usuario();
		this.setMensagem("Usuário salvo com sucesso!");
		
	}

	public List<Usuario> getLista() {
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}

	public Usuario getUsuario(){
		return usuario;
	}

	public void setUsuario(Usuario usuario)	{
		this.usuario = usuario;
	}

	public String logout(){
		System.out.println("entrou no logout");
        AcessoUtil.logOut();
        setMensagem("");
        return "";
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public boolean isLogado() {
		return logado;
	}

	public boolean getLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public Usuario getNovoUsuario() {
		return novoUsuario;
	}

	public void setNovoUsuario(Usuario novoUsuario) {
		this.novoUsuario = novoUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	
}
