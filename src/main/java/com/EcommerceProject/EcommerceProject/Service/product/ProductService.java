package com.EcommerceProject.EcommerceProject.Service.product;


import com.EcommerceProject.EcommerceProject.Model.product.Product;
import com.EcommerceProject.EcommerceProject.dto.ProductDTO;

import java.util.List;


public interface ProductService {

      String saveProductDetails(ProductDTO product);
      String DeleteProductDetails(Integer product_id);

      String updateProductDetails(ProductDTO productDTO);

      List<Product> getProductByCategory(Integer category_id);
      List<Product>  getProductByAvailability(Boolean status);
      List <Product> getAllProduct();
      Product getProductById(Integer product_id);
}
