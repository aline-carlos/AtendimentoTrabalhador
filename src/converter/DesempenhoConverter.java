package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;


import modelo.Agencia;
import modelo.Desempenho;
//import modelo.dao.DesempenhoDAO;

public class DesempenhoConverter implements Converter  {
	//private DesempenhoDAO dao = new DesempenhoDAO();

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		if (arg2 == null || Integer.valueOf(arg2) == 0) {
			return arg2;
		}
		Desempenho desempenho = null;
		try {
		//	Desempenho d = new Desempenho();
	//		d.setPeriodo(Date.valueOf(arg2));
			//d.setPeriodo(Date.valueOf(arg2)); Pegar os dois parametros!
	//		desempenho = dao.buscar(d.getAgencia(), d.getPeriodo());

		} catch (Exception e) {
			System.out.println("Erro......" + e.getMessage());
			e.printStackTrace();
		}
		return desempenho;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		Agencia agencia = null;
		
		if (value == null || ((Desempenho) value).getAgencia().equals(agencia)) {
			return "";
		}
		//System.out.println("Value converter --------->" + value.toString());
		Desempenho desempenho = (Desempenho) value;

		return String.valueOf(desempenho.getAgencia());
	}

}
