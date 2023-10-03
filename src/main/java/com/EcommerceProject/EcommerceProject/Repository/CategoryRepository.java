package com.EcommerceProject.EcommerceProject.Repository;

import com.EcommerceProject.EcommerceProject.Model.category.Category;
import com.EcommerceProject.EcommerceProject.Model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    List<Category> findAll();

    void deleteCategoryById(Integer id);

    Category getCategoryById(Integer id);

    Category findAllByType(String Type);
}
