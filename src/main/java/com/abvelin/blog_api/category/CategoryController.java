package com.abvelin.blog_api.category;

import com.abvelin.blog_api.post.Post;
import com.abvelin.blog_api.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService category_service;

    @GetMapping
    public List<Category> get_all_categories() { return category_service.get_all_categories();}

    @GetMapping("/{id}")
    public Category get_category_by_id(@PathVariable int id){
        return category_service.get_category_by_id(id);
    }

    @PostMapping
    public ResponseEntity<Category> create_category(@RequestBody Category category){

        Category saved_category = category_service.create_category(category);
        return new ResponseEntity<>(saved_category, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update_category(@PathVariable int id, @RequestBody Category category){
        Category updated_category = category_service.update_category(id, category);
        return new ResponseEntity<>(updated_category, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public Category delete_category(@PathVariable int id){
        Category category = category_service.get_category_by_id(id);
        category_service.delete_category(id);
        return category;
    }
}
