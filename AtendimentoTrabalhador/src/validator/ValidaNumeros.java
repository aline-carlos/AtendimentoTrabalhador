package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="validaNumero")  
public class ValidaNumeros implements Validator {

	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		
		try{
			//String str = (Integer) value;
			Long valor = (Long) value;
			//Integer valor = Integer.parseInt(str);
	        if(valor < 0){  
	            throw new ValidatorException(new FacesMessage("Positivas."));  
	        } 
		} catch (ValidatorException e){
			System.out.println("erro validator: " + e.getMessage());
			throw new ValidatorException(new FacesMessage("Número deve ser positivo."));  
			
		} catch (Exception e){
			System.out.println("erro geral: " + e.getMessage());
			throw new ValidatorException(new FacesMessage("Verifique os números informados."));  
			
		}
	        
	}

}
