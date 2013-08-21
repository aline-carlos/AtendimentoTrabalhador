package modelo;

public class Mes {
	private Integer mes;
	private String descricao;
	
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Mes(Integer mes, String descricao) {
		this.mes = mes;
		this.descricao = descricao;
	}
	
	
}
