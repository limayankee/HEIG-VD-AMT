package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet for the user list page
 * @author Julien Leroy & Loic Serafin
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/admin/user"})
public class UserServlet extends HttpServlet
{
    /**
     * Method GET
     * Display the index page
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);
    }
}
