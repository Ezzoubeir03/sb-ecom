package com.ecommerce.project.Controller;

import com.ecommerce.project.Category;
import com.ecommerce.project.Service.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.project.Service.CatagoryService;

//import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {


    @Autowired
    private CatagoryService categoryService;



    //private List<Category> categories = new ArrayList<>();

   @GetMapping("/api/public/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
    @PostMapping("/api/public/categories")
    public String createCategory(@RequestBody Category category){
       categoryService.createCategory(category);
       return "Category added successfully";

    }
}
