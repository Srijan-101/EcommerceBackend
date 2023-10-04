package com.EcommerceProject.EcommerceProject.Repository;

import com.EcommerceProject.EcommerceProject.Model.category.Category;
import com.EcommerceProject.EcommerceProject.Model.product.Product;
import com.EcommerceProject.EcommerceProject.dto.CategoryResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

         List<Product> findProductByCategoryId(Integer id);

         List<Product> findAllByAvailability(Boolean availability);
         Product findProductById(Integer id);


         void deleteById(Integer id);
         List<Product> findAll();
}
