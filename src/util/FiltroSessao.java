package util;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class FiltroSessao implements Filter {
    public void init(FilterConfig config) {     
    }     
	    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {     
        HttpServletRequest httpRequest = (HttpServletRequest)request;     
    
        try {     
            if (!httpRequest.isRequestedSessionIdValid()) {     
                HttpServletResponse httpResponse = (HttpServletResponse)response;     
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/paginas/login.xhtml");     
            } else {     
                chain.doFilter(request, response);     
            }     
        } catch (Exception e) {     
            HttpServletResponse httpResponse = (HttpServletResponse)response;     
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/paginas/login.xhtml");     
        }     
    }     
	    
	    public void destroy() {     
    }     
}  
