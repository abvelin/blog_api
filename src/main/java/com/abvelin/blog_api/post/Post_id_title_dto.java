package com.abvelin.blog_api.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post_dto_id_title {
    private int id;
    private String title;
}
