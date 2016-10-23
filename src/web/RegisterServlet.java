package web;

import dao.UserManager;
import model.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet for the registration
 * GET for the page
 * POST to create the user in the database
 * @author Julien Leroy & Loic Serafin
 */
@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet
{
    @EJB
    private UserManager userManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        if (userManager.getUserID(userName) == -1){

            System.out.println(userName);
            userManager.creatUser(new User(firstName, lastName, userName, password));
            request.getRequestDispatcher("/WEB-INF/regSucces.jsp").forward(request, response);

        } else {
            request.setAttribute("error", "User already exist");
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }
}
