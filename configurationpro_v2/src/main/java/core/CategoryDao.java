package core;

import java.util.List;

public interface CategoryDao {
    List<Category> getAllCategories();

    Category getCategory(int categoryId);

    void saveCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(int categoryId);
}