package com.abvelin.blog_api.post;

import com.abvelin.blog_api.category.Category_dto_id_name;
import com.abvelin.blog_api.category.Category_dto_with_posts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private int id;
    private String title;
    private String content;
    private String photo_url;

    private Category_dto_id_name category;
}

