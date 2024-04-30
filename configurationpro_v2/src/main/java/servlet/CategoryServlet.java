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

import core.Category;
import core.CategoryDao;
import core.CategoryDaoImpl;
import database.DatabaseConnection;
import database.DataAccessException;
import database.DatabaseConfig;
import database.MySqlDatabaseConnection;

@WebServlet("/categories")
public class CategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryDao categoryDao;

    @Override
    public void init() {
        // Retrieve or construct DatabaseConfig with appropriate credentials
        DatabaseConfig config = new DatabaseConfig("jdbc:mysql://localhost:3306/final_project.config", "root", "PoPo2222@.com");        DatabaseConnection dbConnection = new MySqlDatabaseConnection(config);
        categoryDao = new CategoryDaoImpl(dbConnection);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Category> categories = categoryDao.getAllCategories();
            request.setAttribute("categories", categories);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Category.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            // Set an error message
            request.setAttribute("errorMessage", "Unexpected error occurred");
            // Add a redirect to the JSP page
            response.sendRedirect("Category.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}