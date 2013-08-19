package negocio;

//import util.Periodo;
import modelo.Desempenho;

public class ValidaDesempenho {
	
	public boolean validarDados(Desempenho d){
		
		if (! this.validarPeriodo(d.getId().getPeriodo())){
			return false;
		}
		
		return true;
	}
	
	private boolean validarPeriodo(Integer p){
		//Periodo.inicialRelatorios()
		Integer mes = Integer.parseInt(p.toString().substring(4));
		System.out.println("mes" + mes);
		if (mes ==0 || mes > 12){
			return false;
		}
		return true;
	}

}
