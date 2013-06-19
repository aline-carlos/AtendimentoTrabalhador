package util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Periodo {
	public static final Integer atual(){
		String periodo;
		Calendar cal = GregorianCalendar.getInstance();
		Integer ano = cal.get(Calendar.YEAR);
		Integer mes = cal.get(Calendar.MONTH);

		if (mes <= 9) {
			periodo = ano.toString() + "0" + mes.toString();
		}else
			periodo = ano.toString() + mes.toString();
		
		return Integer.parseInt(periodo);
		
		
	}
	public static final Integer anterior(){
		String periodo;
		Calendar cal = GregorianCalendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		Integer ano = cal.get(Calendar.YEAR);
		Integer mes = cal.get(Calendar.MONTH) + 1; //Os meses começam em zero... 
		
		if (mes <= 9) {
			periodo = ano.toString() + "0" + mes.toString();
		}else
			periodo = ano.toString() + mes.toString();
		
		return Integer.parseInt(periodo);
		
	}
	public static final  Integer inicialRelatorios(){
		Calendar cal = GregorianCalendar.getInstance();
		
		/*Busca os registros do ano vigente para exibir*/
		cal.set(cal.get(Calendar.YEAR), Calendar.JANUARY, 1, 0, 0, 0);
		
		Integer ano = cal.get(Calendar.YEAR);
		String parametro = ano.toString();
		parametro += "01";

		return Integer.parseInt(parametro);
	}
	
	public static final  Date dataInicioAno(){
		Calendar cal = GregorianCalendar.getInstance();
		
		/*Busca o primeiro dia do ano vigente*/
		cal.set(cal.get(Calendar.YEAR), Calendar.JANUARY, 1, 0, 0, 0);
		
		System.out.println(cal.getTime());
		
		return cal.getTime();
	}
}
