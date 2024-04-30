package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import database.DataAccessException;

public class UserDaoImpl implements UserDao {
    private DatabaseConnection dbConnection;

    public UserDaoImpl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<User> getAllUsers() throws DataAccessException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM configuration_pro.users;";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int userId = rs.getInt("userId");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String registrationDate = rs.getString("registrationDate");
                String phoneNumber = rs.getString("phoneNumber");
                String address = rs.getString("address");
                users.add(new User.Builder(userId, username, email, password, registrationDate)
                        .phone_number(phoneNumber)
                        .address(address)
                        .build());
            }
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }
        return users;
    }
}