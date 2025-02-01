package com.abvelin.blog_api.post;

import com.abvelin.blog_api.category.Category_id_name_dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post_dto {
    private int id;
    private String title;
    private String content;
    private String photo_url;
    private LocalDateTime createdAt;
    private String time_ago_for_created_at;
    private LocalDateTime updatedAt;
    private String time_ago_for_updated_at;

    private Category_id_name_dto category;


}

