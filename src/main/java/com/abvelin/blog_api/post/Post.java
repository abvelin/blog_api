package com.abvelin.blog_api.post;

import com.abvelin.blog_api.category.Category;
import com.abvelin.blog_api.tag.Tag;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.ocpsoft.prettytime.PrettyTime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "Post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private String photo_url;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "category_id")
//    @JsonBackReference
    private Category category;


//    @ManyToMany
//    @JoinTable(
//            name="post_tag",
//            joinColumns = @JoinColumn(name= "post_id"),
//            inverseJoinColumns = @JoinColumn(name = "tag_id")
//    )
//    private Set<Tag> tags = new HashSet<>();

    // Custom getter for "x time ago" format
    public String get_formatted_created_date() {
        PrettyTime prettyTime = new PrettyTime();
        Date date = Date.from(createdAt.atZone(ZoneId.systemDefault()).toInstant());
        return prettyTime.format(date);
    }

    // Custom getter for "x time ago" format
    public String get_formatted_updated_date() {
        PrettyTime prettyTime = new PrettyTime();
        Date date = Date.from(updatedAt.atZone(ZoneId.systemDefault()).toInstant());
        return prettyTime.format(date);
    }
}
