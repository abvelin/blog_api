package com.abvelin.blog_api.category;

import com.abvelin.blog_api.post.Post_id_title_dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category_with_posts_dto {
    private int id;
    private String name;
    private List<Post_id_title_dto> posts;
}
