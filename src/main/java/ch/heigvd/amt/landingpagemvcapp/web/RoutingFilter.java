package ch.heigvd.amt.landingpagemvcapp.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 *
 * @author Julien Leroy & Loïc Serafin
 */
public class RoutingFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    String path = req.getRequestURI().substring(req.getContextPath().length());
    if (isStaticAsset(path)) {
      chain.doFilter(request, response);
    } else {
      request.getRequestDispatcher("/frontController" + path).forward(request, response);
    }
  }

  @Override
  public void destroy() {
  }

  private boolean isStaticAsset(String path) {
    if (path.startsWith("/less")) {
      return true;
    } else if (path.startsWith("/css")) {
      return true;
    } else if (path.startsWith("/img")) {
      return true;
    } else if (path.startsWith("/js")) {
      return true;
    } else if (path.startsWith("/vendor")) {
      return true;
    }
    return false;
  }
  

}
