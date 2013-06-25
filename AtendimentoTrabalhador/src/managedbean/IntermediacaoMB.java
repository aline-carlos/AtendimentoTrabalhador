package managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import negocio.Ranking;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import modelo.Agencia;
import modelo.Desempenho;
import modelo.Regional;
import modelo.dao.AgenciaDAO;
import modelo.dao.DesempenhoDAO;
import modelo.dao.RegionalDAO;


@ManagedBean(name="intermediacaoMB")
@SessionScoped
public class IntermediacaoMB implements Serializable{

	private static final long serialVersionUID = -605404502661552597L; 
	
	private Desempenho desempenho;
	private DesempenhoDAO dao = new DesempenhoDAO();
	private List<Desempenho> lista = new ArrayList<Desempenho>();
	private List<Ranking> rankinglist = new ArrayList<Ranking>();
	private CartesianChartModel grafico;
	private int nroRegiao = 0;
	private int nroAgencia = 0;
	private String titulo = "";
	
	private String valor = "ff";
	
	public IntermediacaoMB() {
		desempenho = new Desempenho();
	}

	public String listarIntermediacao(){
		this.setTitulo("Intermediação");
		this.buscarDados("intermediacao");	
		this.criaGraficoIntermediacao();
		return "/paginas/intermediacao";
	}

	public String listarSeguro(){
		this.setTitulo("Seguro Desemprego");
		this.buscarDados("segurodesemprego");	
		this.criaGraficoSeguro();
		return "/paginas/seguro";
	}
	
	public String listarCtps(){
		this.setTitulo("Carteira de Trabalho");
		this.buscarDados("ctps");
		this.criaGraficoCtps();
		return "/paginas/ctps";
	}
	
	public String listarRanking(){
		this.setTitulo("Ranking de Colocação no Mercado de Trabalho - Mês");
		rankinglist = dao.ranking();
		return "/paginas/ranking";
	}

	public String listarRankingAcumulado(){
		this.setTitulo("Ranking de Colocação no Mercado de Trabalho - Acumulado do ano");
		rankinglist = dao.rankingAcumulado();

		if (this.nroAgencia == 0)
			if (this.nroRegiao == 0)
				rankinglist = dao.rankingAcumulado();
			else{
				Regional regional = new Regional();
				RegionalDAO daor = new RegionalDAO();
				regional = daor.consultar(this.getNroRegiao());
				System.out.println("antes");
				rankinglist = dao.rankingAcumulado(regional);
				System.out.println("depois");
			}
		else{
			Agencia agencia = new Agencia();
			AgenciaDAO daoa = new AgenciaDAO();
			agencia = daoa.consultar(this.getNroAgencia());
			rankinglist = dao.rankingAcumulado(agencia );
		}
		
		return "/paginas/rankingacumulado";
	}

	public String getVoltar(){
		String pagina="";
		if (this.nroAgencia == 0 && this.nroRegiao == 0)
			pagina= "/index";
		else
			pagina = "/paginas/mapas/rf"+nroRegiao;
		return pagina;
			
	}
	
	public String getLocal(){
		String local ="";
		if (this.nroAgencia == 0 && this.nroRegiao == 0)
			local = "Total do Estado";
		else
			local = "Região Funcional "+ nroRegiao;
		return local;
			
	}
	
	public String getVoltarAgencia(){
		return "/paginas/agencia";
			
	}
	
	public String getLocalAgencia(){
		String local ="";
		if (this.nroAgencia == 0)
			local = "";
		else
			local = "Dados da Agência";
		return local;
			
	}
	
	private void buscarDados(String relatorio){
		if (this.nroAgencia == 0)
			if (this.nroRegiao == 0)
				this.listarEstado(relatorio);
			else
				this.listarRegional(relatorio);
		else
			this.listarAgencia(relatorio);
	}
	
	private void listarEstado(String relatorio){
		
		this.setTitulo("Total do Estado");
		lista = dao.listarTotaisAnuais(relatorio);
		
	}
	private void listarRegional(String relatorio){
		Regional regional = new Regional();
		RegionalDAO daor = new RegionalDAO();
		regional = daor.consultar(this.getNroRegiao());
		this.setTitulo(this.getTitulo()+ " - " + regional.getNome() + " " + regional.getDescricao() );
		lista = dao.listar(regional, relatorio);

	}

	private void listarAgencia(String relatorio){
		Agencia agencia = new Agencia();
		AgenciaDAO daoa = new AgenciaDAO();
		agencia = daoa.consultar(this.getNroAgencia());
		this.setTitulo(this.getTitulo()+ " - " + agencia.getNome() );
		lista = dao.listar(agencia, relatorio);
	}

	private void criaGraficoIntermediacao() {  
        grafico = new CartesianChartModel();  
  
        ChartSeries vagas = new ChartSeries();  
        vagas.setLabel("Vagas");  
  
        ChartSeries inscritos = new ChartSeries();  
        inscritos.setLabel("Inscritos");  

        ChartSeries encaminhados = new ChartSeries();  
        encaminhados.setLabel("Encaminhados");  
  
        ChartSeries colocados = new ChartSeries();  
        colocados.setLabel("Colocados");
        
        for( Desempenho d: this.lista )  
        {  
        	inscritos.set(d.getMesabrev(), d.getInscritos());  
        	encaminhados.set(d.getMesabrev(), d.getEncaminhados());
        	vagas.set(d.getMesabrev(), d.getVagas());  
        	colocados.set(d.getMesabrev(), d.getColocados());
        }  
        grafico.addSeries(inscritos); 
        grafico.addSeries(encaminhados);  
        grafico.addSeries(vagas);  
        grafico.addSeries(colocados); 
     
    }
	
	private void criaGraficoSeguro() {  
        grafico = new CartesianChartModel();  
  
        ChartSeries seguro = new ChartSeries();  
        seguro.setLabel("Requerentes");  
        
        for( Desempenho d: this.lista )  
        {  
        	seguro.set(d.getMesabrev(), d.getSegurodesemprego());
        }  
        grafico.addSeries(seguro); 
    }

	private void criaGraficoCtps() {  
        grafico = new CartesianChartModel();  
  
        ChartSeries carteira = new ChartSeries();  
        carteira.setLabel("Volume de emissões");  
        
        for( Desempenho d: this.lista )  
        {  
        	carteira.set(d.getMesabrev(), d.getCtps());
        }  
        grafico.addSeries(carteira); 
    }
	
	public Desempenho getDesempenho() {
		return desempenho;
	}

	public void setDesempenho(Desempenho desempenho) {
		this.desempenho = desempenho;
	}

	public List<Desempenho> getLista() {
		return lista;
	}

	public void setLista(List<Desempenho> lista) {
		this.lista = lista;
	}

	public DesempenhoDAO getDao() {
		return dao;
	}

	public void setDao(DesempenhoDAO dao) {
		this.dao = dao;
	}
	
	public CartesianChartModel getGrafico() {  
        return grafico;  
    } 

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public int getNroRegiao() {
		return nroRegiao;
	}
 
	public void setNroRegiao(int nroRegiao) {
		this.nroRegiao = nroRegiao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	} 

	public List<Ranking> getRankinglist() {
		return rankinglist;
	}

	public void setRankinglist(List<Ranking> rankinglist) {
		this.rankinglist = rankinglist;
	}

	public int getNroAgencia() {
		return nroAgencia;
	}

	public void setNroAgencia(int nroAgencia) {
		this.nroAgencia = nroAgencia;
	}
	
	public String getPaginaInicial(){
		this.setNroRegiao(0);
		this.setNroAgencia(0);
		return null;
		
	}

	public String getRf1() {
		this.setNroAgencia(0);
		this.setNroRegiao(1);
		return null;
	}
	
	public String getRf2() {
		this.setNroAgencia(0);
		this.setNroRegiao(2);
		return null;
	}
	
	public String getRf3() {
		this.setNroAgencia(0);
		this.setNroRegiao(3);
		return null;
	}
	
	public String getRf4() {
		this.setNroAgencia(0);
		this.setNroRegiao(4);
		return null;
	}
	
	public String getRf5() {
		this.setNroAgencia(0);
		this.setNroRegiao(5);
		return null;
	}
	
	public String getRf6() {
		this.setNroAgencia(0);
		this.setNroRegiao(6);
		return null;
	}
	
	public String getRf7() {
		this.setNroAgencia(0);
		this.setNroRegiao(7);
		return null;
	}
	
	public String getRf8() {
		this.setNroAgencia(0);
		this.setNroRegiao(8);
		return null;
	}
	
	public String getRf9() {
		this.setNroAgencia(0);
		this.setNroRegiao(9);
		return null;
	}
	
	public String getIntermediacao() {
		this.listarIntermediacao();
		return null;
	}

	public String getSeguro() {
		this.listarSeguro();
		return null;
	}
	
	public String getCtps() {
		this.listarCtps();
		return null;
	}
	
	public String getRanking() {
		this.listarRanking();
		return null;
	}
	
	public String getRankingAcumulado() {
		this.listarRankingAcumulado();
		return null;
	}
	

/*	public void localiza(){
		FacesContext ctx = FacesContext.getCurrentInstance();
        String viewId = ctx.getViewRoot().getViewId();
        
        String[] p = viewId.split("/");
        String[] q = p[p.length-1].split("\\.");
        System.out.println("o q saiu? " + q[0].substring(2));
        if (q[0].startsWith("rf")){
        	System.out.println("o q saiu2? " + q[0].substring(2));
        }
 		
	}*/
	
	/*
	public void teste(){
		System.out.println("entrou em teste");
		System.out.println("passou no teste! "+ nroRegiao);
	}

	public void teste2(){
		
		System.out.println("passou no teste2! "+ valor);
	}

	public String teste3(){
		
		System.out.println("entrou no teste3");
		return "dialog:teste";  
	}
	public void teste4(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		
        String viewId = ctx.getViewRoot().getViewId();

		System.out.println("entrou em teste4: "+ viewId);
		
	}
	*/
	
	
}
