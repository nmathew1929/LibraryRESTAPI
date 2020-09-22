package com.example.navinmathew.LibraryRESTAPI.services;


import com.example.navinmathew.LibraryRESTAPI.domain.Category;

import java.util.List;

public interface CategoryService {

    Category findCategoryById(Long id);
    List<Category> findAllCategories();
    Category saveCategory(Category category);
    void deleteCategory(Long id);
}
