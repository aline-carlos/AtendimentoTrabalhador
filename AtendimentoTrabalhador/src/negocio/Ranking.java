package negocio;

import modelo.Municipio;

public class Ranking implements Comparable<Ranking> {
	
	private Municipio municipio;
	
	private Integer periodo;
	
	private float meta;
	
	private Long admitidoscaged;
	
	private Long colocados;
	
	private String mes;

	private String mesabrev;

	private Double indice;
	
	private Double percMetaAtingida;
	
	private Integer posicao;
	
	private Long metaAbsoluta;
	
	private Long saldo;

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public float getMeta() {
		return meta;
	}

	public void setMeta(float meta) {
		this.meta = meta;
	}

	public Long getAdmitidoscaged() {
		return admitidoscaged;
	}

	public void setAdmitidoscaged(Long admitidoscaged) {
		this.admitidoscaged = admitidoscaged;
	}

	public Long getColocados() {
		return colocados;
	}

	public void setColocados(Long colocados) {
		this.colocados = colocados;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getMesabrev() {
		return mesabrev;
	}

	public void setMesabrev(String mesabrev) {
		this.mesabrev = mesabrev;
	}

	public Double getIndice() {
		return indice;
	}

	public void setIndice(Double indice) {
		this.indice = indice;
	}

	public Integer getPosicao() {
		return posicao;
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

	public Double getPercMetaAtingida() {
		return percMetaAtingida;
	}

	public void setPercMetaAtingida(Double percMetaAtingida) {
		this.percMetaAtingida = percMetaAtingida;
	}

	@Override
	public int compareTo(Ranking r) {
		// Multiplico por -1 para retornar decrescente
		return (percMetaAtingida.compareTo(r.percMetaAtingida)* (-1));
	}

	public Long getMetaAbsoluta() {
		return metaAbsoluta;
	}

	public void setMetaAbsoluta(Long metaAbsoluta) {
		this.metaAbsoluta = metaAbsoluta;
	}

	public Long getSaldo() {
		return saldo;
	}

	public void setSaldo(Long saldo) {
		this.saldo = saldo;
	}

}
