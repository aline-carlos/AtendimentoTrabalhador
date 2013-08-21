package modelo.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import negocio.Ranking;

import modelo.Agencia;
import modelo.Desempenho;
import modelo.DesempenhoPK;
import modelo.Regional;

import util.AcessoUtil;
import util.Meses;
import util.Periodo;

public class DesempenhoDAO extends DaoGenericoImp<Desempenho, Serializable>{
	
	public void gravar(Desempenho p) {
		p.setUsuario(AcessoUtil.userLogged());
		p.setDtmodificacao(new Date());
		super.salvar(p);
	}

	public Desempenho atualizar(Desempenho p) {
		p.setUsuario(AcessoUtil.userLogged());
		p.setDtmodificacao(new Date());
		return super.atualizar(p);
	}

	public Desempenho consultar(DesempenhoPK pk) {
		return super.pesquisarPorId(pk);
	}
	
	public List<Desempenho> listar() {
		return super.todos();
	}
	
	public List<Desempenho> listarTotaisAnuais(String relatorio) {

		String sqlQuery  = "select d.id.periodo, sum(d.vagas), sum(d.inscritos), sum(d.encaminhados), sum(d.colocados), " +
				           " sum(d.segurodesemprego), sum(d.ctps)" +
				           " from Desempenho d " +
				           " where d.id.periodo >= :periodo  " +
				           "   and exists ( select 1" +
				           "                 from  Publicacao p " +
				           "                where  p.periodo = d.id.periodo " +
				           "                  and  p." + relatorio +" = true )" +
				           " group by d.id.periodo " +
				           " order by d.id.periodo ";
		final Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("periodo", Periodo.inicialRelatorios());
		
		Iterator retornoBD = super.listPesqParam(sqlQuery, parameters).iterator();
		
		List<Desempenho> lista = retornaLista(retornoBD);
		
		return lista;
	}
	
	public List<Desempenho> listar(Regional regional, String relatorio) {
		
		String sqlQuery  = "select d.id.periodo, sum(d.vagas), sum(d.inscritos), sum(d.encaminhados), sum(d.colocados), " +
				           " sum(d.segurodesemprego), sum(d.ctps)" +
				           " from Desempenho d " +
				           " where d.id.periodo >= :periodo  " +
				           " and   d.id.agencia in ( select a.codigo " +
				           "                         from Agencia a, Municipio m  " +
				           "                         where a.municipio = m.codigo " +
				           "                           and m.regional.codigo = :regional )  " +
				           " and exists ( select 1" +
				           "                from  Publicacao p " +
				           "                where  p.periodo = d.id.periodo " +
				           "                  and  p." + relatorio + " = true )" +
				           " group by d.id.periodo " +
				           " order by d.id.periodo ";
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("periodo", Periodo.inicialRelatorios());
		parameters.put("regional", regional.getCodigo());
		
		Iterator retornoBD = super.listPesqParam(sqlQuery, parameters).iterator();
		
		List<Desempenho> lista =  retornaLista(retornoBD);
		return lista;
		
	}

	public List<Desempenho> listar(Agencia agencia, String relatorio) {

		String sqlQuery  = "select d.id.periodo, sum(d.vagas), sum(d.inscritos), sum(d.encaminhados), sum(d.colocados), " +
				           " sum(d.segurodesemprego), sum(d.ctps)" +
				           " from Desempenho d " +
				           " where d.id.periodo >= :periodo  " +
				           " and   d.id.agencia =  :agencia  " +
				           " and exists ( select 1" +
				           "                from  Publicacao p " +
				           "               where  p.periodo = d.id.periodo " +
				           "                 and  p." + relatorio + " = true )" +
				           " group by d.id.periodo " +
				           " order by d.id.periodo ";
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("periodo", Periodo.inicialRelatorios());
		parameters.put("agencia", agencia.getCodigo());
		
		Iterator retornoBD = super.listPesqParam(sqlQuery, parameters).iterator();
		
		List<Desempenho> lista = retornaLista(retornoBD);
		return lista;
		
	}
	
	public List<Ranking> ranking(Integer periodo) {
		String sqlQuery  = "select m.codigo, c.id.periodo, t.valor, c.admitidos, c.admitidos*(t.valor/100), sum(d.colocados)" +
							"from  Municipio m, Meta t, Caged c, Agencia a, Desempenho d " + 
							"where t.id.municipio = m.codigo " + 
							"and   c.id.municipio = m.codigo " +
							"and   a.municipio    = m.codigo " + 
							"and   d.agencia      = a.codigo " +
							"and   c.id.periodo   = d.id.periodo " +
							"and   current_date between t.id.desde and COALESCE(t.ate, '2999-12-31')" +
							"and   c.id.periodo = :periodo " +
							"and exists ( select 1" +
					        "               from  Publicacao p " +
					        "              where  p.periodo = d.id.periodo " +
							"                and  p.intermediacao = true" +
							"                and  p.caged = true )" +
							"group by m.codigo, c.id.periodo, t.valor, c.admitidos " ;

		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("periodo", periodo);
		
		Iterator retornoBD = super.listPesqParam(sqlQuery, parameters).iterator();

		//if (retornoBD.hasNext()){
			List<Ranking> lista =  retornaListaRanking(retornoBD);
			lista = rankingPosicao(lista);
			return lista;
		//}
		//System.out.println("vai retornar nulo");
		//return null;
	}
	
	public List<Ranking> rankingAcumulado() {
		String sqlQuery  = "select m.codigo, 201301, t.valor, sum(c.admitidos), sum(c.admitidos)*(t.valor/100), sum(d.colocados)" +
							"from  Municipio m, Meta t, Caged c, Agencia a, Desempenho d " + 
							"where t.id.municipio = m.codigo " + 
							"and   c.id.municipio = m.codigo " +
							"and   a.municipio    = m.codigo " + 
							"and   d.agencia      = a.codigo " +
							"and   c.id.periodo   = d.id.periodo " +
							"and   :inicioAno between t.id.desde and COALESCE(t.ate, '2999-12-31')" +
							"and   c.id.periodo >= :periodo " +
							"and exists ( select 1" +
							"               from  Publicacao p " +
							"              where  p.periodo = d.id.periodo " +
							"                and  p.intermediacao = true" +
							"                and  p.caged = true )" +
							"group by m.codigo, t.valor " ;

		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("periodo", Periodo.inicialRelatorios());
		parameters.put("inicioAno", Periodo.dataInicioAno());
		
		Iterator retornoBD = super.listPesqParam(sqlQuery, parameters).iterator();
		
		List<Ranking> lista =  retornaListaRanking(retornoBD);
		
		lista = rankingPosicao(lista);
		return lista;
		
	}
	
	public List<Ranking> rankingAcumulado(Regional regional) {
		
		String sqlQuery  = "select m.codigo, 201301, t.valor, sum(c.admitidos), sum(c.admitidos)*(t.valor/100), sum(d.colocados)" +
							"from  Municipio m, Meta t, Caged c, Agencia a, Desempenho d " + 
							"where t.id.municipio = m.codigo " + 
							"and   c.id.municipio = m.codigo " +
							"and   a.municipio    = m.codigo " + 
							"and   d.agencia      = a.codigo " +
							"and   c.id.periodo   = d.id.periodo " +
							"and   current_date between t.id.desde and COALESCE(t.ate, '2999-12-31')" +
							"and   c.id.periodo >= :periodo " +
							"and   m.regional.codigo = :regional " +
							"and exists ( select 1" +
							"               from  Publicacao p " +
							"              where  p.periodo = d.id.periodo " +
							"                and  p.intermediacao = true" +
							"                and  p.caged = true )" +
							"group by m.codigo, t.valor " ;

		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("periodo", Periodo.inicialRelatorios());
		parameters.put("regional", regional.getCodigo());

		Iterator retornoBD = super.listPesqParam(sqlQuery, parameters).iterator();
		
		List<Ranking> lista =  retornaListaRanking(retornoBD);
		
		lista = rankingPosicao(lista);

		return lista;
		
	}

	public List<Ranking> rankingAcumulado(Agencia agencia) {
		String sqlQuery  = "select m.codigo, 201301, t.valor, sum(c.admitidos), sum(c.admitidos)*(t.valor/100), sum(d.colocados)" +
							"from  Municipio m, Meta t, Caged c, Agencia a, Desempenho d " + 
							"where t.id.municipio = m.codigo " + 
							"and   c.id.municipio = m.codigo " +
							"and   a.municipio    = m.codigo " + 
							"and   d.id.agencia   = a.codigo " +
							"and   c.id.periodo   = d.id.periodo " +
							"and   current_date between t.id.desde and COALESCE(t.ate, '2999-12-31')" +
							"and   c.id.periodo >= :periodo " +
							"and   m.codigo      = :municipio " +
							"and exists ( select 1" +
							"               from  Publicacao p " +
							"              where  p.periodo = d.id.periodo " +
							"                and  p.intermediacao = true" +
							"                and  p.caged = true )" +
							"group by m.codigo, t.valor " ;

		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("periodo", Periodo.inicialRelatorios());
		parameters.put("municipio", agencia.getMunicipio().getCodigo());
		
		Iterator retornoBD = super.listPesqParam(sqlQuery, parameters).iterator();
		
		List<Ranking> lista =  retornaListaRanking(retornoBD);
		
		lista = rankingPosicao(lista);
		return lista;
		
	}
	
	
	private List<Desempenho> retornaLista(Iterator i){
		
		List<Desempenho> lista = new ArrayList<Desempenho>();
		
		while ( i.hasNext() ) {
			Object[] row = (Object[]) i.next();
			Desempenho des = new Desempenho();
			DesempenhoPK desPK = new DesempenhoPK();
			desPK.setAgencia(1);
			
			Integer periodo = (Integer) row[0];
			Long vagas = (Long) row[1];
			Long inscritos = (Long) row[2];
			Long encaminhados = (Long) row[3];
			Long colocados = (Long) row[4];
			Long segurodesemprego = (Long) row[5];
			Long ctps = (Long) row[6];
			
			desPK.setPeriodo(periodo);
			des.setVagas(vagas);
			des.setInscritos(inscritos);
			des.setEncaminhados(encaminhados);
			des.setColocados(colocados);
			des.setSegurodesemprego(segurodesemprego);
			des.setCtps(ctps);
			des.setId(desPK);
			des.setMes(Meses.meses.get(Integer.parseInt(periodo.toString().substring(4))));
			des.setMesabrev(Meses.mesesabrev.get(Integer.parseInt(periodo.toString().substring(4))));
			lista.add(des);
			
		}
		return lista; 
	}
	
	private List<Ranking> retornaListaRanking(Iterator i){
		
		List<Ranking> lista = new ArrayList<Ranking>();
		lista.clear();
		MunicipioDAO mDAO = new MunicipioDAO();
		while ( i.hasNext() ) {
			
			Object[] row = (Object[]) i.next();
			Ranking rk = new Ranking();
			
			Integer codMunic = (Integer) row[0];
			Integer periodo = (Integer) row[1];
			Float meta = (Float) row[2];
			Long admcaged = (Long) row[3];
			Long metaAbs = Math.round(((Float) row[4]).doubleValue());
			Long colocados = (Long) row[5];
			
			if ( colocados > 0){
				rk.setMunicipio(mDAO.consultar(codMunic));
				rk.setPeriodo(periodo);
				rk.setMeta(meta);
				rk.setAdmitidoscaged(admcaged);
				rk.setMetaAbsoluta(metaAbs);
				rk.setColocados(colocados);
				rk.setIndice(Math.round((colocados.floatValue()/admcaged.floatValue()*100) * 100.0)/100.0);
				rk.setPercMetaAtingida(Math.round(colocados/(admcaged * meta/100) * 10000) /100.0);
				rk.setMes(Meses.meses.get(Integer.parseInt(periodo.toString().substring(4))));
				rk.setMesabrev(Meses.mesesabrev.get(Integer.parseInt(periodo.toString().substring(4))));
				rk.setSaldo(colocados-metaAbs);
				lista.add(rk);
			}
		}
		
		return lista; 
	}

	private List<Ranking> rankingPosicao(List<Ranking> lista){
		
		Collections.sort(lista);
		Iterator<Ranking> i = lista.iterator();
		Integer posicao = 0;
		
		while ( i.hasNext() ) {
			Ranking row = i.next();
			posicao++;
			row.setPosicao(posicao);
		}
		return lista; 
	}

	
}
