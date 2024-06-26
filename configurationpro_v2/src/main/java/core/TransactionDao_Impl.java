package core;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import database.DataAccessException;

public class TransactionDao_Impl implements TransactionDao {
    private DatabaseConnection dbConnection;

    public TransactionDao_Impl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<Transactions> getAllTransactions() throws DataAccessException {
        List<Transactions> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int transactionId = rs.getInt("transaction_id");
                int listingId = rs.getInt("listing_id");
                int buyerId = rs.getInt("buyer_id");
                int sellerId = rs.getInt("seller_id");
                String transactionDate = rs.getString("transaction_date");
                double transactionAmount = rs.getDouble("transaction_amount");

                Transactions transaction = new Transactions(transactionId, listingId, buyerId, sellerId, transactionDate, transactionAmount);
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }

        return transactions;
    }
}