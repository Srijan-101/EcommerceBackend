package com.EcommerceProject.EcommerceProject.Controller;


import com.EcommerceProject.EcommerceProject.Model.category.Category;
import com.EcommerceProject.EcommerceProject.Service.category.CategoryService;
import com.EcommerceProject.EcommerceProject.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;
    CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping("/save")
    public ResponseEntity<Object> createCategory(@RequestBody Category category){
        return ResponseEntity.ok(
                new ApiResponse(true,
                        "Category created sucessfully!",
                        categoryService.createCategory(category)));
    }


//    @PutMapping ("/update")
//    public String updateCategory(@RequestBody Category category){
//        return  categoryService.updateCategory(category);
//    }

    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Integer id){
       return categoryService.deleteCategory(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getCategory(){
        return ResponseEntity.ok(
                new ApiResponse(true,
                        "Category fetched sucessfully!",
                        categoryService.getAllCategory()));
    }

}
