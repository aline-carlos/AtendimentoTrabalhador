package util;

//import javax.el.ELContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

//import managedbean.IntermediacaoMB;

public class ControleAmbito implements PhaseListener {

	private static final long serialVersionUID = 4531116518372923356L;
	
	private static String[] paths = null;

	@Override
	public void afterPhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforePhase(PhaseEvent event) {
		System.out.println("entrou no phase...");
		FacesContext ctx = event.getFacesContext();
        String viewId = ctx.getViewRoot().getViewId();

        for (String s : getPaths(ctx)) {
        	
        	String[] p = s.split("=");
        	if (viewId.indexOf(p[0]) > -1) {
        
		        /*ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		        IntermediacaoMB bean = (IntermediacaoMB) FacesContext.getCurrentInstance().getApplication()
		            .getELResolver().getValue(elContext, null, "intermediacaoMB");*/
		        
		        System.out.println("entrou no phase para ajuste:" + viewId);
        	}
        }        
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}
	
	private String[] getPaths(FacesContext ctx) {

        if (paths == null) {
            //logger.config("loading jsfsecurity.protected ...");
            String s = ctx.getExternalContext().getInitParameter("jsf.ambito");
            if (s != null) {
                paths = s.split(",");
            }
        }
        return paths;
	}
	
	

}
