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

import core.PropertyFeatures;
import core.PropertyFeatures_Dao;
import core.PropertyFeatures_Impl;
import database.DatabaseConnection;
import database.DataAccessException;
import database.DatabaseConfig;
import database.MySqlDatabaseConnection;

@WebServlet("/propertyfeatures")
public class PropertyFeaturesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PropertyFeatures_Dao propertyFeaturesDao;

    @Override
    public void init() {
        // Retrieve or construct DatabaseConfig with appropriate credentials
        DatabaseConfig config = new DatabaseConfig("jdbc:mysql://localhost:3306/configuration_pro", "root", "PoPo2222@.com");
        DatabaseConnection dbConnection = new MySqlDatabaseConnection(config);
        try {
			propertyFeaturesDao = new PropertyFeatures_Impl(dbConnection.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<PropertyFeatures> propertyFeatures = propertyFeaturesDao.getAllFeatures();
            System.out.println("Number of property features: " + propertyFeatures.size());
            for (PropertyFeatures propertyFeature : propertyFeatures) {
                System.out.println("Feature ID: " + propertyFeature.getFeature_id());
                System.out.println("Listing ID: " + propertyFeature.getListing_id());
                System.out.println("Feature Name: " + propertyFeature.getFeature_name());
                System.out.println("Feature Value: " + propertyFeature.getFeature_value());
            }
            request.setAttribute("propertyFeatures", propertyFeatures);
            RequestDispatcher dispatcher = request.getRequestDispatcher("PropertyFeatures.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            // Log the exception
            e.printStackTrace();
            // Set an error message
            request.setAttribute("errorMessage", "Error accessing the database");
            // Add a redirect to the JSP page
            response.sendRedirect("PropertyFeatures.jsp");
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            // Set an error message
            request.setAttribute("errorMessage", "Unexpected error occurred");
            // Add a redirect to the JSP page
            response.sendRedirect("PropertyFeatures.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}