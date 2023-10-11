package com.EcommerceProject.EcommerceProject.Service.product;


import com.EcommerceProject.EcommerceProject.Model.category.Category;
import com.EcommerceProject.EcommerceProject.Model.product.Product;
import com.EcommerceProject.EcommerceProject.Repository.CategoryRepository;
import com.EcommerceProject.EcommerceProject.Repository.ProductRepository;
import com.EcommerceProject.EcommerceProject.dto.CategoryResponseDto;
import com.EcommerceProject.EcommerceProject.dto.ProductRequestDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService{

    private final ProductRepository productrepository;
    private final CategoryRepository categoryRepository;

    ProductServiceImp(ProductRepository productrepository,CategoryRepository categoryRepository){
        this.productrepository = productrepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public String saveProductDetails(ProductRequestDto productDTO) {

         Category existingCategory = categoryRepository
                 .getCategoryById(productDTO.getCategory_id());

         if(existingCategory != null){

             Product newProduct = new Product();
             newProduct.setName(productDTO.getName());
             newProduct.setDescription(productDTO.getDescription());
             newProduct.setPrice(productDTO.getPrice());
             newProduct.setCategory(existingCategory);

             productrepository.save(newProduct);
         }else {
             return "No category found with this id" + productDTO.getCategory_id();
         }

         return "Saved sucessfully";
    }

    @Override
    public String DeleteProductDetails(Integer product_id) {
        productrepository.deleteById(product_id);
        return "Delete Sucessfully";
    }

    @Override
    public String updateProductDetails(ProductRequestDto productDTO) {

        Product existingProduct = productrepository.findProductById(productDTO.getId());
        if(existingProduct != null){
            Category existingCategory = categoryRepository
                    .getCategoryById(productDTO.getCategory_id());
            if(existingCategory !=null ){
                 existingProduct.setName(productDTO.getName());
                 existingProduct.setDescription(productDTO.getDescription());
                 existingProduct.setPrice(productDTO.getPrice());
                 existingProduct.setCategory(existingCategory);
                 existingProduct.setAvailability(productDTO.isAvailability());
                 productrepository.save(existingProduct);
            }
        }
        return "Product updated successfully";
    }

    @Override
    public CategoryResponseDto getProductByCategory(Integer category_id) {
        List<Product> products = productrepository.findProductByCategoryId(category_id);
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();

        if (!products.isEmpty()) {
            Product firstProduct = products.get(0);
            categoryResponseDto.setId(firstProduct.getCategory().getId());
            categoryResponseDto.setType(firstProduct.getCategory().getType());

            categoryResponseDto.setProductList(products);
        }

        return categoryResponseDto;
    }

    @Override
    public List<Product> getProductByAvailability(Boolean status) {
        return productrepository.findAllByAvailability(status);
    }

    @Override
    public List<Product> getAllProduct() {
        return productrepository.findAll();
    }

    @Override
    public Product getProductById(Integer product_id) {
        return productrepository.findProductById(product_id);
    }


}
