package com.abvelin.blog_api.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post_id_title_dto {
    private int id;
    private String title;
}
