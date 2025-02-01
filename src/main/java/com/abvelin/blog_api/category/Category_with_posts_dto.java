package com.abvelin.blog_api.category;

import com.abvelin.blog_api.post.Post_dto_id_title;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category_dto_with_posts {
    private int id;
    private String name;
    private List<Post_dto_id_title> posts;
}
