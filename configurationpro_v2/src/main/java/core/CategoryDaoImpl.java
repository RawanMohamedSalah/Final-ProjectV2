package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.CategoryDao;
import core.Category;
import database.DatabaseConnection;
import database.DataAccessException;

public class CategoryDaoImpl implements CategoryDao {
    private DatabaseConnection dbConnection;

    public CategoryDaoImpl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM categories";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int categoryId = rs.getInt("category_id");
                String categoryName = rs.getString("category_name");
                categories.add(new Category(categoryId, categoryName));
            }
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }

        return categories;
    }

    @Override
    public Category getCategory(int categoryId) {
        Category category = null;
        String sql = "SELECT * FROM categories WHERE category_id =?";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, categoryId);
            try (ResultSet rs = preparedStatement.executeQuery()) {

                if (rs.next()) {
                    String categoryName = rs.getString("category_name");
                    category = new Category(categoryId, categoryName);
                }
            }
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }

        return category;
    }

    @Override
    public void saveCategory(Category category) {
        String sql = "INSERT INTO categories (category_name) VALUES (?)";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, category.getCategoryName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }
    }

    @Override
    public void updateCategory(Category category) {
        String sql = "UPDATE categories SET category_name =? WHERE category_id =?";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, category.getCategoryName());
            preparedStatement.setInt(2, category.getCategoryId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }
    }

    @Override
    public void deleteCategory(int categoryId) {
        String sql = "DELETE FROM categories WHERE category_id =?";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, categoryId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        }
    }
}