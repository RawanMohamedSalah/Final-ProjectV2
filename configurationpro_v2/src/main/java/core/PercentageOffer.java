package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import database.DataAccessException;

public class OfferImpl implements OfferDao {
    private DatabaseConnection dbConnection;

    public OfferImpl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<OfferType> getAllOffers() throws DataAccessException {
        List<OfferType> offers = new ArrayList<>();
        String sql = "SELECT * FROM offer_type;";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                String offerTypeId = rs.getString("offer_type_id");
                String offerTypeName = rs.getString("offer_type_name");
                double discountPercentage = rs.getDouble("discount_percentage");

                OfferType offerType = new PercentageOffer(discountPercentage);
                offerType.setOfferTypeId(offerTypeId);
                offerType.setOfferTypeName(offerTypeName);
                offerType.setDiscountPercentage(String.format("%.2f%%", discountPercentage));

                offers.add(offerType);
            }
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }
        return offers;
    }
}