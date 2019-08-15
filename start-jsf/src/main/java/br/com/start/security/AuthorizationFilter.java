package br.com.start.security;

import java.io.IOException;

import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("*.xhtml")
public class AuthorizationFilter implements Filter  {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			HttpServletRequest reqt = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            HttpSession session = reqt.getSession(false);
            String reqURI = reqt.getRequestURI();
            
            if (reqURI.indexOf("/login.xhtml") >= 0
				|| (session != null && session.getAttribute("usuario") != null)
				|| reqURI.indexOf("/publico") >= 0
				|| reqURI.contains("javax.faces.resource")
				||(reqURI.matches(".*(css|js|jpg|jpeg|png]).*"))
            		) {
            		 
            	chain.doFilter(request, response);
			} else {
				resp.sendRedirect(reqt.getContextPath() + "/login.xhtml");
			}
		} catch (Exception e) {
			System.err.println(e.getCause());
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		
	}

	
}
