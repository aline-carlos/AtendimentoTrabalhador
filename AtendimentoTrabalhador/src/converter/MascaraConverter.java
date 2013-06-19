package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "mascaraConverter")
public class MascaraConverter implements Converter {

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		 if(valor != null || valor != "") {  
	            valor = valor.toString().replaceAll("[- /.]", "");  
	            valor = valor.toString().replaceAll("[-()]", "");  
	        }  
	        return valor;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object valor) {
		 return valor.toString();  
	}

}
