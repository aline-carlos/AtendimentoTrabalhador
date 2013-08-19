package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.Agencia;
import modelo.dao.AgenciaDAO;

@FacesConverter(value = "agenciaConverter")
public class AgenciaConverter implements Converter {
	
	AgenciaDAO dao = new AgenciaDAO();

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (arg2 == null || Integer.valueOf(arg2) == 0) {
			return arg2;
		}
		Agencia agencia = null;
		System.out.println("getasObjet");
		System.out.println("arg2:" + arg2);
		try {
			Agencia a = new Agencia();
			a.setCodigo(Integer.valueOf(arg2));
			agencia = dao.consultar(a.getCodigo());
			System.out.println("agencia: " + agencia.toString());
		} catch (NumberFormatException e) {
			System.out.println("Erro......" + e.getMessage());
			e.printStackTrace();
		}
		return agencia;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if (value == null || value == "")
			return "";
		if (((Agencia) value).getCodigo() == 0) {
			return "";
		}
		//System.out.println("Value converter --------->" + value.toString());
		Agencia agencia = (Agencia) value;
		//System.out.println("getasString");
		//System.out.println("value:" + value);

		return String.valueOf(agencia.getCodigo());
	}

}
