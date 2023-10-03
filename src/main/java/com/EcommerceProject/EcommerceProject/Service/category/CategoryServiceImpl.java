package com.EcommerceProject.EcommerceProject.Service.category;


import com.EcommerceProject.EcommerceProject.Model.category.Category;
import com.EcommerceProject.EcommerceProject.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryrepository;

    CategoryServiceImpl(CategoryRepository categoryrepository){
        this.categoryrepository = categoryrepository;
    }
    @Override
    public List<Category> getAllCategory() {
        return categoryrepository.findAll();
    }

    @Override
    public String deleteCategory(Integer id) {
        Optional<Category> existing =
                 categoryrepository.findById(id);
        if(existing.isPresent()){
            categoryrepository.deleteById(id);
        }else {
            return "No category found with this Id";
        }

        return "Delete sucessfull";
    }

    @Override
    public String updateCategory(Category category) {
        Optional<Category> existingCategory =
                categoryrepository.findById(category.getId());

        if(existingCategory.isPresent()){
             Category updateCategory = existingCategory.get();
             updateCategory.setType(updateCategory.getType());

             categoryrepository.save(updateCategory);
        }else {
            return "No category found with this Id";
        }

        return "Update sucessful!";
    }

    @Override
    public String createCategory(Category category) {
        Category existingCategory =
                categoryrepository.findAllByType(category.getType());
        if (existingCategory == null) {
            categoryrepository.save(category);
            return "Category created successfully";
        } else  {
            return "Category with the same name already exists";
        }
    }
}
