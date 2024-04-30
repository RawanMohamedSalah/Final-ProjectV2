package core;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DataAccessException;
import database.DatabaseConnection;

public class DocumentsDaoImpl implements DocumentsDao{
    private DatabaseConnection dbConnection;

    public DocumentsDaoImpl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<Documents> getAllDocuments(){
        List<Documents> documents = new ArrayList<>();
        String sql = "SELECT * FROM final_project.document";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                String Documents_id = rs.getString("Documents_id");
                String Documents_name = rs.getString("Documents_name");
                String Documents_description = rs.getString("Documents_description");
                String Documents_image = rs.getString("Documents_image");
                documents.add(new Documents(Documents_id,Documents_name,Documents_description,Documents_image));
            }
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);

        }
        return documents;
    }
}