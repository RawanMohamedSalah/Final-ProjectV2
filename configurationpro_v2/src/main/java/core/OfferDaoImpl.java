package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DataAccessException;
import database.DatabaseConnection;

public class OfferDaoImpl implements OfferDao {
    private DatabaseConnection dbConnection;

    public OfferDaoImpl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<Offer> getAllOffers() {
        List<Offer> offers = new ArrayList<>();
        String sql = "SELECT * FROM final_project.offer";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int offerId = rs.getInt("offerId");
                String offerDescription = rs.getString("offerDescription");
                offers.add(new Offer(offerId, offerDescription));
            }
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }

        return offers;
    }
}