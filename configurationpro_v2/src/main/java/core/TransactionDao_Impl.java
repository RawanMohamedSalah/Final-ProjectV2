package core;



import java.sql.Connection;
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
    public List<Transactions> getAllTransactions() throws Exception {
        List<Transactions> transactions = new ArrayList<>();
        String sql = "SELECT * FROM configuration_pro.transactions;";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int transactionId = rs.getInt("transaction_id");
                int propertyId = rs.getInt("property_id");
                int buyerId = rs.getInt("buyer_id");
                int sellerId = rs.getInt("seller_id");
                String transactionDate = rs.getString("transaction_date");
                double transactionAmount = rs.getDouble("transaction_amount");
                transactions.add(new Transactions(transactionId, propertyId, buyerId, sellerId, transactionDate, transactionAmount));
            }
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }

        return transactions;
    }
}