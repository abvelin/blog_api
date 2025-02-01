package com.abvelin.blog_api.post;

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

//    @Autowired
    private final PostService post_service;

    public PostController(PostService post_service){
        this.post_service = post_service;
    }



    @Autowired
    private CategoryService category_service;


    @PostMapping
    public Post create_post(@RequestBody Post post){
        return post_service.create_post(post);
    }

    @GetMapping
    public List<Post_dto> get_all_posts(){
        return post_service.get_all_posts();
    }

    @GetMapping("/{id}")
    public Post_dto get_post_by_id(@PathVariable int id){
        return post_service.get_post_by_id(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post_dto> update_post(@PathVariable int id, @RequestBody Post_dto post_dto){
        Post_dto updated_post = post_service.update_post(id, post_dto);
        return new ResponseEntity<>(updated_post, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete_post(@PathVariable int id){
        post_service.delete_post(id);
    }

}
