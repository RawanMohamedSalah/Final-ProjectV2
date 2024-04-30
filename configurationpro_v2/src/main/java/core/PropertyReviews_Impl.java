package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import database.DataAccessException;
import database.DatabaseConfig;
import database.MySqlDatabaseConnection;

public class PropertyReviews_Impl implements PropertyReviews_Dao {
    private DatabaseConnection dbConnection;

    public PropertyReviews_Impl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<PropertyReviews> getAllPropertyReviews() throws Exception {
        List<PropertyReviews> reviews = new ArrayList<>();
        String sql = "SELECT * FROM property_reviews;";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                String reviewerName = rs.getString("reviewer_name");
                int rating = rs.getInt("rating");
                String comment = rs.getString("comment");
                PropertyReviews review = new PropertyReviews(reviewerName, rating, comment);
                reviews.add(review);
            }
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }

        return reviews;
    }

    @Override
    public void addPropertyReview(PropertyReviews review) throws Exception {
        String sql = "INSERT INTO property_reviews (reviewer_name, rating, comment) VALUES (?, ?, ?);";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, review.getReviewerName());
            preparedStatement.setInt(2, review.getRating());
            preparedStatement.setString(3, review.getComment());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }
    }
}