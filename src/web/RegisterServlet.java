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

    /**
     * Method POST
     * If successful redirect user to login page
     * If not redirect to error page with message
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        boolean error = false;
        String empty = "";

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        if (userName.equals("")){
            empty += "username empty, ";
            error = true;
        }

        if (password.equals("")){
            empty += "password empty, ";
            error = true;
        }

        if (firstName.equals("")){
            empty += "first name empty, ";
            error = true;
        }

        if (lastName.equals("")){
            empty += "last name empty ";
            error = true;
        }

        if (error){
            request.setAttribute("error", empty);
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }

        if (userManager.getUserID(userName) == -1){

            userManager.creatUser(new User(firstName, lastName, userName, password));
            request.getRequestDispatcher("/WEB-INF/regSucces.jsp").forward(request, response);

        } else {
            request.setAttribute("error", "User already exist");
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
    }

    /**
     * Method GET
     * Show the register form
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }
}
