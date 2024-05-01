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

import core.Transactions;
import core.TransactionDao;
import core.TransactionDao_Impl;
import database.DatabaseConnection;
import database.DataAccessException;
import database.DatabaseConfig;
import database.MySqlDatabaseConnection;

@WebServlet("/transactions")
public class TransactionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TransactionDao transactionDao;

    @Override
    public void init() {
        // Retrieve or construct DatabaseConfig with appropriate credentials
        DatabaseConfig config = new DatabaseConfig("jdbc:mysql://localhost:3306/configuration_pro", "root", "PoPo2222@.com");
        DatabaseConnection dbConnection = new MySqlDatabaseConnection(config);
        transactionDao = new TransactionDao_Impl(dbConnection);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Transactions> transactions = transactionDao.getAllTransactions();
            System.out.println("Number of transactions: " + transactions.size());
            for (Transactions transaction : transactions) {
                System.out.println("Transaction ID: " + transaction.getTransaction_id());
                System.out.println("Property ID: " + transaction.getListing_id());
                System.out.println("Buyer ID: " + transaction.getBuyer_id());
                System.out.println("Seller ID: " + transaction.getSeller_id());
                System.out.println("Transaction Date: " + transaction.getTransaction_date());
                System.out.println("Transaction Amount: " + transaction.getTransaction_amount());
            }
            request.setAttribute("transactions", transactions);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Transactions.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            // Log the exception
            e.printStackTrace();
            // Set an error message
            request.setAttribute("errorMessage", "Error accessing the database");
            // Add a redirect to the JSP page
            response.sendRedirect("Transactions.jsp");
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            // Set an error message
            request.setAttribute("errorMessage", "Unexpected error occurred");
            // Add a redirect to the JSP page
            response.sendRedirect("Transactions.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}