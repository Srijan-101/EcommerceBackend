package com.EcommerceProject.EcommerceProject.Controller;


import com.EcommerceProject.EcommerceProject.Model.category.Category;
import com.EcommerceProject.EcommerceProject.Service.category.CategoryService;
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
    public String createCategory(@RequestBody Category category){
       return categoryService.createCategory(category);
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
    public List<Category> getCategory(){
        return categoryService.getAllCategory();
    }

}
