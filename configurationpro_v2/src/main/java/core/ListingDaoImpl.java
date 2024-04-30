package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import database.DataAccessException;
import core.Listing;

public class ListingDaoImpl implements ListingDao {
    private DatabaseConnection dbConnection;

    public ListingDaoImpl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<Listing> getAllListings() {
        List<Listing> listings = new ArrayList<>();
        String sql = "SELECT * FROM configuration_pro.listings;";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int listingId = rs.getInt("listingId");
                int cityId = rs.getInt("cityId");
                int categoryId = rs.getInt("categoryId");
                int agentId = rs.getInt("agentId");
                int bedrooms = rs.getInt("bedrooms");
                int bathrooms = rs.getInt("bathrooms");
                double squareFootage = rs.getDouble("squareFootage");
                double price = rs.getDouble("price");

                listings.add(new Listing(listingId, cityId, categoryId, agentId, bedrooms, bathrooms, squareFootage, price));
            }
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }

        return listings;
    }
}