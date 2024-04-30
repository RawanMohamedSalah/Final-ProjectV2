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

import core.OfferType;
import core.OfferDao;
import core.OfferImpl;
import database.DatabaseConnection;
import database.DataAccessException;
import database.DatabaseConfig;
import database.MySqlDatabaseConnection;

@WebServlet("/offers")
public class OfferServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OfferDao offerDao;

    @Override
    public void init() {
        // Retrieve or construct DatabaseConfig with appropriate credentials
        DatabaseConfig config = new DatabaseConfig("jdbc:mysql://localhost:3306/configuration_pro", "root", "PoPo2222@.com");
        DatabaseConnection dbConnection = new MySqlDatabaseConnection(config);
        offerDao = new OfferImpl(dbConnection);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<OfferType> offerTypes = offerDao.getAllOfferTypes();
            System.out.println("Number of offer types: " + offerTypes.size());
            for (OfferType offerType : offerTypes) {
                System.out.println("Offer Type ID: " + offerType.getOfferTypeId());
                System.out.println("Offer Type Name: " + offerType.getOfferTypeName());
                System.out.println("Discount Percentage: " + offerType.getDiscountPercentage());
            }
            request.setAttribute("offerTypes", offerTypes);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Offer.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            // Log the exception
            e.printStackTrace();
            // Set an error message
            request.setAttribute("errorMessage", "Error accessing the database");
            // Add a redirect to the JSP page
            response.sendRedirect("Offer.jsp");
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            // Set an error message
            request.setAttribute("errorMessage", "Unexpected error occurred");
            // Add a redirect to the JSP page
            response.sendRedirect("Offer.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}