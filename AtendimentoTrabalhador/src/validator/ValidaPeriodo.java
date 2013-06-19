package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="validaPeriodo")
public class ValidaPeriodo implements Validator {

	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		System.out.println(value);
		String valor = (String) value;
		Integer mes = Integer.parseInt(valor.substring(4));  
		System.out.println("mes" + mes);
		if (mes ==0 || mes > 12){
			System.out.println("mes invalido");
            throw new ValidatorException(new FacesMessage("Mês inválido.")); 
            
        } 
	}

}
