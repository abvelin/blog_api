package com.abvelin.blog_api.category;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin
public class CategoryController {
//    @Autowired
    private final CategoryService category_service;

    public CategoryController(CategoryService category_service){
        this.category_service = category_service;
    }

    @PostMapping
    public ResponseEntity<Category> create_category(@RequestBody Category category){

        Category saved_category = category_service.create_category(category);
        return new ResponseEntity<>(saved_category, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Category_dto> get_all_categories() { return category_service.get_all_categories();}

//    @GetMapping
//    public List<CategoryDto> get_all_categories() { return category_service.get_all_categories();}

    @GetMapping("/{id}")
    public Category_id_name_dto get_category(@PathVariable int id){
        return category_service.get_category_by_id(id);
    }

    @GetMapping("/{id}/posts")
    public Category_with_posts_dto get_category_with_posts(@PathVariable int id){
        return category_service.get_category_with_posts(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category_dto> update_category(@PathVariable int id, @RequestBody Category_dto category_dto){

        return new ResponseEntity<>(category_service
                .update_category(id, category_dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public Category_id_name_dto delete_category(@PathVariable int id){
        Category_id_name_dto category_to_delete = category_service.get_category_by_id(id);
        category_service.delete_category(id);
        return category_to_delete;
    }
}
