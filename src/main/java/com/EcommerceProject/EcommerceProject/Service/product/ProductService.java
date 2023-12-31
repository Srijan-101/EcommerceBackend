package com.EcommerceProject.EcommerceProject.Service.product;


import com.EcommerceProject.EcommerceProject.Model.product.Product;
import com.EcommerceProject.EcommerceProject.dto.CategoryResponseDto;
import com.EcommerceProject.EcommerceProject.dto.ProductRequestDto;

import java.util.List;


public interface ProductService {

      String saveProductDetails(ProductRequestDto product);
      String DeleteProductDetails(Integer product_id);

      String updateProductDetails(ProductRequestDto productDTO);
      CategoryResponseDto getProductByCategory(Integer category_id);
      List<Product>  getProductByAvailability(Boolean status);
      List <Product> getAllProduct();
      Product getProductById(Integer product_id);
}
