package com.abvelin.blog_api.tag;

import com.abvelin.blog_api.post.Post;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private int displayOrder;

//    @ManyToMany(mappedBy = "tags")
//    private Set<Post> posts = new HashSet<>();


}
