package util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class AcessoUtil {

    public static String logIn(String defaultViewId, String login) {

        String viewId = defaultViewId;
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)ctx.getExternalContext().getSession(false);
        if (session != null) {
            session.setAttribute(ControleAcesso.JSF_SECURITY_KEY, "147369");
            session.setAttribute(ControleAcesso.LOGGED_USER, login);
            String s = (String)session.getAttribute(ControleAcesso.VIEWID_KEY);
            if (s != null) {
                viewId = s;
            }
        }
        return viewId;
    }

    public static boolean isLoggedIn() {

        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)ctx.getExternalContext().getSession(false);
        if (session != null) {
            String s = (String)session.getAttribute(ControleAcesso.JSF_SECURITY_KEY);
            if (s != null && s.equals("147369")) {
                return true;
            }
        }
        return false;
    }

    public static String userLogged() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)ctx.getExternalContext().getSession(false);
        if (session != null) {
            String s = (String)session.getAttribute(ControleAcesso.LOGGED_USER);
            return s;
        }
        return null;
    }

    public static void logOut() {

        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)ctx.getExternalContext().getSession(false);
        if (session != null) {
            session.removeAttribute(ControleAcesso.JSF_SECURITY_KEY);
            session.removeAttribute(ControleAcesso.LOGGED_USER);
            //ctx.getApplication().getNavigationHandler().handleNavigation(ctx, null, ("/index.xhtml"));
            //ctx.getViewRoot().setViewId("/index");
            //index.xhtml
        }
    }
}
