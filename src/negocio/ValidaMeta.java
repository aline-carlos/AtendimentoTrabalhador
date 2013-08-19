package negocio;

import java.util.Date;

import modelo.Meta;
import modelo.Municipio;
import modelo.dao.MetaDAO;
import modelo.dao.MunicipioDAO;

public class ValidaMeta {
	
	public String validarMeta(Meta novaMeta){
		
		MetaDAO dao = new MetaDAO();
		Meta metaAnterior = new Meta();
		Municipio municipio = new Municipio();
		MunicipioDAO municipioDAO = new	MunicipioDAO();
		
		municipio = municipioDAO.consultar(novaMeta.getId().getMunicipio());
		metaAnterior = dao.consultarAtual(municipio);
		
		Date inicioAnterior = metaAnterior.getId().getDesde();
		
		if (novaMeta.getId().getDesde().before(inicioAnterior)) {
			return "A nova meta deve iniciar após a meta vigente.";
			
		}
		
		return "";
	}
	
}
