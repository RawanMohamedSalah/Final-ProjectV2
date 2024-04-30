package core;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PropertyFeatures_Impl implements PropertyFeatures_Dao {

    private Connection connection;

    public PropertyFeatures_Impl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<PropertyFeatures> getAllFeatures() throws SQLException {
        String query = "SELECT * FROM property_features";

        List<PropertyFeatures> features = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int featureId = resultSet.getInt("feature_id");
                int listingId = resultSet.getInt("listing_id");
                String featureName = resultSet.getString("feature_name");
                String featureValue = resultSet.getString("feature_value");

                PropertyFeatures feature = new PropertyFeatures(featureId, listingId, featureName, featureValue);
                features.add(feature);
            }
        } catch (SQLException e) {
            // Handle SQL exception
            e.printStackTrace();
        }

        return features;
    }
}