package com.abvelin.blog_api.post;

import com.abvelin.blog_api.category.Category;
import com.abvelin.blog_api.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin
//@CrossOrigin(origins = "*")
public class PostController {

    @Autowired
    private PostService post_service;

    @Autowired
    private CategoryService category_service;

    @GetMapping
    public List<Post> get_all_posts(){
        return post_service.get_all_posts();
    }

    @GetMapping("/{id}")
    public Post get_post_by_id(@PathVariable int id){
        return post_service.get_post_by_id(id);
    }

    @PostMapping
    public ResponseEntity<Post> create_post(@RequestBody Post post){

        Category category = category_service.get_category_by_id(post.getCategory().getId());
        post.setCategory(category);

        Post saved_post = post_service.create_post(post);
        return new ResponseEntity<>(saved_post, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> update_post(@PathVariable int id, @RequestBody Post post){
       Post updated_post = post_service.update_post(id, post);
       return new ResponseEntity<>(updated_post, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete_post(@PathVariable int id){
        post_service.delete_post(id);
    }

}
