package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class ControleAcesso implements PhaseListener {
	/* Baseado em http://www.deslatech.com.br/?q=node/7 */
	private static final long serialVersionUID = -781294566130715727L;
	
    public static final String JSF_SECURITY_KEY = "__jsfsecurity__";
    public static final String VIEWID_KEY = "__viewId";
    public static final String LOGGED_USER = "__login__";
	 
	private static String[] protectedPaths = null;

	public void afterPhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void beforePhase(PhaseEvent event) {
		FacesContext ctx = event.getFacesContext();
        String viewId = ctx.getViewRoot().getViewId();
        HttpSession httpSession = (HttpSession)ctx.getExternalContext().getSession(true);
        System.out.println("entrou... viewId:" + viewId);
        
        for (String s : getProtectedPaths(ctx)) {
    			
        	String[] p = s.split("=");
        	if (viewId.indexOf(p[0]) > -1) {
        		System.out.println("1..." );
        		//HttpSession httpSession = (HttpSession)ctx.getExternalContext().getSession(true);
        		if (httpSession == null || httpSession.getAttribute(JSF_SECURITY_KEY) == null) {
        			System.out.println("2..." );
        			httpSession.setAttribute(VIEWID_KEY, viewId);
        			
        			ctx.getApplication().getNavigationHandler().handleNavigation(ctx, null, ("/paginas/login.xhtml" ));
        			ctx.addMessage(null, new FacesMessage("A p�gina solicitada requer que o usu�rio esteja autenticado."));
        			 
        		} else {

        			String roles = (String)httpSession.getAttribute("__roles");
        			
        			 if (roles != null && roles.indexOf(p[1]) == -1) {
        				 ctx.getApplication().getNavigationHandler().handleNavigation(ctx, null, "");
        				 ctx.addMessage(null, new FacesMessage("P�gina solicitada n�o est� autorizada."));
        			 }

        		}
        		break;
        		
        	}
        	
        }
        
	}

	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}
	
    private String[] getProtectedPaths(FacesContext ctx) {

        if (protectedPaths == null) {
            String s = ctx.getExternalContext().getInitParameter("jsfsecurity.protected");
            if (s != null) {
                protectedPaths = s.split(",");
            }
        }
        return protectedPaths;
    }
	

}
