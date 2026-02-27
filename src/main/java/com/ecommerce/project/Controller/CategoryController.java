package com.ecommerce.project.Controller;

import com.ecommerce.project.Category;
import com.ecommerce.project.Service.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.project.Service.CatagoryService;
import org.springframework.web.server.ResponseStatusException;

//import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {


    @Autowired
    private CatagoryService categoryService;



    //private List<Category> categories = new ArrayList<>();

   @GetMapping("/api/public/categories")
    public ResponseEntity<List<Category>> getAllCategories(){
       List<Category> categories = categoryService.getAllCategories();
       return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @PostMapping("/api/public/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category){
       categoryService.createCategory(category);
       return new ResponseEntity<>("Category added successfully", HttpStatus.CREATED);

    }
    @DeleteMapping("/api/admin/categories/{categoryId}")
    public ResponseEntity <String> deleteCategory(@PathVariable Long categoryId){
       try {
           String  status = categoryService.deleteCategory(categoryId);
           //return ResponseEntity.ok(status);
           return ResponseEntity.status(HttpStatus.OK).body(status);
       }catch(ResponseStatusException e){
           return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }

    }
    @PutMapping("/api/public/categories/{categryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category, @PathVariable Long categoryId){
   try{
       Category sevedCategory  = categoryService.updateCategory(category, categoryId);
       //return ResponseEntity.ok(status);
       return new ResponseEntity<>("Category with category id : " + categoryId, HttpStatus.OK);
   } catch (ResponseStatusException e){
   return new ResponseEntity<>(e.getReason(), e.getStatusCode());
   }
    }
}
