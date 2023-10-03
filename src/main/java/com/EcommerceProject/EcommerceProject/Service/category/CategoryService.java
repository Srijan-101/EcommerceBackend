package com.EcommerceProject.EcommerceProject.Service.category;

import com.EcommerceProject.EcommerceProject.Model.category.Category;

import java.util.List;

public interface CategoryService {
      List<Category> getAllCategory();
      String deleteCategory(Integer category_id);
      String updateCategory(Category category);
      String createCategory(Category category);
}
