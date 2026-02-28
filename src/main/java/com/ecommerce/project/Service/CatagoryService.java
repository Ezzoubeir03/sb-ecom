package com.ecommerce.project.Service;

import com.ecommerce.project.Category;

import java.util.List;
public interface CatagoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);

    String deleteCategory(Long categoryId);
    Category updateCategory(Category category, Long categoryId);
}
