package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import database.DataAccessException;

public class ListingDaoImpl implements ListingDao {
    private DatabaseConnection dbConnection;

    public ListingDaoImpl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<Listing> getAllListings()throws DataAccessException { 
        List<Listing> listings = new ArrayList<>();
        String sql = "SELECT * FROM listingstore1.listings";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int city_id = rs.getInt("city_id");
                int category_id = rs.getInt("category_id");
                int agent_id = rs.getInt("agent_id");
                int offer_id = rs.getInt("offer_id");
                int property_type_id = rs.getInt("property_type_id");
                int documents_id = rs.getInt("documents_id");
                int bedrooms = rs.getInt("bedrooms");
                int bathrooms = rs.getInt("bathrooms");
                double square_footage = rs.getDouble("square_footage");
                double price = rs.getDouble("price");

                Listing.Builder builder = new Listing.Builder(id, city_id, category_id, agent_id);
                builder.offerId(offer_id);
                builder.propertyTypeId(property_type_id);
                builder.documentsId(documents_id);
                builder.bedrooms(bedrooms);
                builder.bathrooms(bathrooms);
                builder.squareFootage(square_footage);
                builder.price(price);

                Listing listing = builder.build();
                listings.add(listing);
            }
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }

        return listings;
    }
}