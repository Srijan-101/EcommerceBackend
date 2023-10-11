package com.EcommerceProject.EcommerceProject.Controller;


import com.EcommerceProject.EcommerceProject.Model.product.Product;
import com.EcommerceProject.EcommerceProject.Service.product.ProductService;
import com.EcommerceProject.EcommerceProject.dto.ApiResponse;
import com.EcommerceProject.EcommerceProject.dto.CategoryResponseDto;
import com.EcommerceProject.EcommerceProject.dto.ProductRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;
    ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/getProduct")
    public List<Product>  getAllProduct(){
       return productService.getAllProduct();
    }

    @PostMapping("/saveProduct")
    public  ResponseEntity<ApiResponse> saveProduct(@RequestBody @Valid ProductRequestDto productDTO){
        return ResponseEntity.ok(
                new ApiResponse(true,
                        "sucessfully fetched!",
                        productService.saveProductDetails(productDTO)));

    }

    @GetMapping("/findByCategory/{id}")
    public CategoryResponseDto findProductByCategoryId(@PathVariable Integer id){
        return productService.getProductByCategory(id);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String DeleteProduct(@PathVariable Integer id){
        return productService.DeleteProductDetails(id);
    }

    @PutMapping("/updateProduct")
    public String DeleteProduct(@RequestBody ProductRequestDto productDTO ){
         return productService.updateProductDetails(productDTO);
    }
    @GetMapping("/GetProductById/{id}")
    public Product getProductById(@PathVariable Integer id){
         return productService.getProductById(id);
    }
}