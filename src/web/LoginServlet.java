package web;

import dao.UserManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet for the login page
 * GET for the page
 * POST for login the user and create the http session
 * @author Julien Leroy & Loic Serafin
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet
{

    @EJB
    private UserManager userManager;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Object userSession = request.getSession().getAttribute("userSession");


        if ( userSession != null ) {
            response.sendRedirect("admin/user");
        } else {
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println(userManager.checkUser(request.getParameter("userName"), request.getParameter("password")));

        if (userManager.checkUser(request.getParameter("userName"), request.getParameter("password")) ){
            request.getSession().setAttribute("userSession", userManager.getUserID(request.getParameter("user")));
            response.sendRedirect("admin/user");
        }
        else {
            request.setAttribute("error", "Login error");
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }

    }
}
