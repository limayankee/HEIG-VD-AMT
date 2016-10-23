package web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filter for the restricted area /admin/*
 * @author Julien Leroy & Loic Serafin
 */
@WebFilter(filterName = "UserFilter", urlPatterns = {"/admin/*"})
public class UserFilter implements Filter
{
    public void destroy()
    {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException
    {
        Object userSession = ((HttpServletRequest) req).getSession().getAttribute("userSession");

        if ( userSession == null ) { //redirect to sit root if no userSession find
            ((HttpServletResponse) resp).sendRedirect("/app");
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException
    {

    }

}
