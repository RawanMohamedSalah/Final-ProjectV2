package servlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import core.User;
import core.UserDao;
import core.UserDaoImpl;
import database.DatabaseConnection;
import database.DataAccessException;
import database.DatabaseConfig;
import database.MySqlDatabaseConnection;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    @Override
    public void init() {
        // Retrieve or construct DatabaseConfig with appropriate credentials
        DatabaseConfig config = new DatabaseConfig("jdbc:mysql://localhost:3306/configuration_pro", "root", "PoPo2222@.com");
        DatabaseConnection dbConnection = new MySqlDatabaseConnection(config);
        userDao = new UserDaoImpl(dbConnection);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<User> users = userDao.getAllUsers();
            System.out.println("Number of users: " + users.size());
            for (User user : users) {
                System.out.println("User ID: " + user.getUserId());
                System.out.println("Username: " + user.getUsername());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Password: " + user.getPassword());
                System.out.println("Registration Date: " + user.getRegistrationDate());
                System.out.println("Phone Number: " + user.getPhoneNumber());
                System.out.println("Address: " + user.getAddress());
            }
            request.setAttribute("users", users);
            RequestDispatcher dispatcher = request.getRequestDispatcher("User.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            // Log the exception
            e.printStackTrace();
            // Set an error message
            request.setAttribute("errorMessage", "Error accessing the database");
            // Add a redirect to the JSP page
            response.sendRedirect("User.jsp");
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            // Set an error message
            request.setAttribute("errorMessage", "Unexpected error occurred");
            // Add a redirect to the JSP page
            response.sendRedirect("User.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}