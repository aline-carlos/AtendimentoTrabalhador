package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.dao.MunicipioDAO;
import modelo.Municipio;

@FacesConverter(value = "municipioConverter")
public class MunicipioConverter implements Converter {
	
	private MunicipioDAO dao = new MunicipioDAO();
	
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (arg2 == null || Integer.valueOf(arg2) == 0) {
			return null;
		}
		return dao.consultar(Integer.valueOf(arg2));
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 == null || arg2 == "")
			return "";
		
		if (((Municipio) arg2).getCodigo() == 0) {
			return "";
		}
		Municipio m = (Municipio) arg2;
		return String.valueOf(m.getCodigo());
	}

}
