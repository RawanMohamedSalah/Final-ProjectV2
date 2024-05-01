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

public class PropertyReviews_Impl implements PropertyReviews_Dao {
    private DatabaseConnection dbConnection;

    public PropertyReviews_Impl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<PropertyReviews> getAllPropertyReviews() throws DataAccessException {
        List<PropertyReviews> propertyReviews = new ArrayList<>();
        String sql = "SELECT * FROM propertyreviews";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int reviewId = rs.getInt("reviewId");
                int listingId = rs.getInt("listingId");
                int userId = rs.getInt("userId");
                Float rating = rs.getFloat("rating");
                String reviewText = rs.getString("reviewText");
                Date reviewDate = rs.getDate("reviewDate");

                PropertyReviews propertyReview = new PropertyReviews(reviewId, listingId, userId, rating, reviewText, reviewDate);
                propertyReviews.add(propertyReview);
            }
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }

        return propertyReviews;
    }
}