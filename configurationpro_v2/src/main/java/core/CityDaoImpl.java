package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import database.DataAccessException;

public class CityDaoImpl implements CityDao {
    private DatabaseConnection dbConnection;

    public CityDaoImpl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();
        String sql = "SELECT * FROM cities";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int cityId = rs.getInt("city_id");
                String cityName = rs.getString("city_name");
                cities.add(new City(cityId, cityName));
            }
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }

        return cities;
    }

    @Override
    public City getCity(int cityId) {
        City city = null;
        String sql = "SELECT * FROM cities WHERE city_id =?";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, cityId);
            try (ResultSet rs = preparedStatement.executeQuery()) {

                if (rs.next()) {
                    String cityName = rs.getString("city_name");
                    city = new City(cityId, cityName);
                }
            }
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }

        return city;
    }

    @Override
    public void saveCity(City city) {
        String sql = "INSERT INTO cities (city_name) VALUES (?)";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, city.getCityName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }
    }

    @Override
    public void updateCity(City city) {
        String sql = "UPDATE cities SET city_name =? WHERE city_id =?";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, city.getCityName());
            preparedStatement.setInt(2, city.getCityId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }
    }

    @Override
    public void deleteCity(int cityId) {
        String sql = "DELETE FROM cities WHERE city_id =?";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, cityId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }
    }
}