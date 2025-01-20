package com.abvelin.blog_api.tag;

import com.abvelin.blog_api.tag.Tag;
import com.abvelin.blog_api.tag.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
@CrossOrigin
public class TagController {
    @Autowired
    private TagService tag_service;

    @GetMapping
    public List<Tag> get_all_tags(){
        return tag_service.get_all_tags();
    }

    @GetMapping("/{id}")
    public Tag get_category_by_id(@PathVariable int id){
        return tag_service.get_tag_by_id(id);
    }

    @PostMapping
    public ResponseEntity<Tag> create_category(@RequestBody Tag category){

        Tag saved_category = tag_service.create_tag(category);
        return new ResponseEntity<>(saved_category, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tag> update_category(@PathVariable int id, @RequestBody Tag category){
        Tag updated_category = tag_service.update_tag(id, category);
        return new ResponseEntity<>(updated_category, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public Tag delete_category(@PathVariable int id){
        Tag category = tag_service.get_tag_by_id(id);
        tag_service.delete_tag(id);
        return category;
    }
}
