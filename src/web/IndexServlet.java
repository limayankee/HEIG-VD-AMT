package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet for the index page
 * Only GET
 * @author Julien Leroy & Loic Serafin
 */
@WebServlet(name = "IndexServlet", urlPatterns = "")
public class IndexServlet extends HttpServlet
{
    /**
     * Method GET
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
