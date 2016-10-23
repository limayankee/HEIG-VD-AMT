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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Object counter = request.getSession().getAttribute("counter");

        if (counter == null){
            request.getSession().setAttribute("counter", new Integer(1));
        } else {
            Integer oldCounter = (Integer) request.getSession().getAttribute("counter");

            request.getSession().setAttribute("counter", oldCounter + 1);
        }

        request.setAttribute("test", 1);
        request.getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);

    }
}
