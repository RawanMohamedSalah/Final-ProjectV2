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

import core.PropertyReviews;
import core.PropertyReviews_Dao;
import core.PropertyReviews_Impl;
import database.DatabaseConnection;
import database.DataAccessException;
import database.DatabaseConfig;
import database.MySqlDatabaseConnection;

@WebServlet("/propertyreviews")
public class PropertyReviewsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PropertyReviews_Dao propertyReviewsDao;

    @Override
    public void init() {
        // Retrieve or construct DatabaseConfig with appropriate credentials
        DatabaseConfig config = new DatabaseConfig("jdbc:mysql://localhost:3306/configuration_pro", "root", "PoPo2222@.com");
        DatabaseConnection dbConnection = new MySqlDatabaseConnection(config);
        propertyReviewsDao = new PropertyReviews_Impl(dbConnection);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<PropertyReviews> propertyReviews = propertyReviewsDao.getAllPropertyReviews();
            System.out.println("Number of property reviews: " + propertyReviews.size());
            for (PropertyReviews propertyReview : propertyReviews) {
                System.out.println("Reviewer Name: " + propertyReview.getReviewerName());
                System.out.println("Rating: " + propertyReview.getRating());
                System.out.println("Comment: " + propertyReview.getComment());
            }
            request.setAttribute("propertyReviews", propertyReviews);
            RequestDispatcher dispatcher = request.getRequestDispatcher("PropertyReviews.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            // Log the exception
            e.printStackTrace();
            // Set an error message
            request.setAttribute("errorMessage", "Error accessing the database");
            // Add a redirect to the JSP page
            response.sendRedirect("PropertyReviews.jsp");
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            // Set an error message
            request.setAttribute("errorMessage", "Unexpected error occurred");
            // Add a redirect to the JSP page
            response.sendRedirect("PropertyReviews.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}