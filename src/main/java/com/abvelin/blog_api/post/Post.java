package com.abvelin.blog_api.post;

import com.abvelin.blog_api.category.Category;
import com.abvelin.blog_api.tag.Tag;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String title;
    private String content;
    private String photo_url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private Category category;

//    @ManyToMany
//    @JoinTable(
//            name="post_tag",
//            joinColumns = @JoinColumn(name= "post_id"),
//            inverseJoinColumns = @JoinColumn(name = "tag_id")
//    )
//    private Set<Tag> tags = new HashSet<>();
}
