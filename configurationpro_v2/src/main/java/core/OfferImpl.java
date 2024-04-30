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
public List<OfferType> getAllOfferTypes() throws Exception {
        List<OfferType> offerTypes = new ArrayList<>();
        String sql = "SELECT * FROM configuration_pro.offer_types;";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int offerTypeId = rs.getInt("offerTypeId");
                String offerTypeName = rs.getString("offerTypeName");
                double discountPercentage = rs.getDouble("discountPercentage");
                offerTypes.add(new OfferType(offerTypeId, offerTypeName, discountPercentage));
            }
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }

        return offerTypes;
    }
}