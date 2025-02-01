package com.abvelin.blog_api.post;

import com.abvelin.blog_api.category.Category;
import com.abvelin.blog_api.category.Category_id_name_dto;

public class PostMapper {
    // Convert Post to PostDTO
    public static Post_dto toDto(Post post) {
        Post_dto post_dto = new Post_dto();
        post_dto.setId(post.getId());
        post_dto.setTitle(post.getTitle());
        post_dto.setContent(post.getContent());
        post_dto.setPhoto_url(post.getPhoto_url());
        post_dto.setCreatedAt(post.getCreatedAt());
        post_dto.setTime_ago_for_created_at(post.get_formatted_created_date());
//        dto.setCreatedDate(entity.getFormattedCreatedDate());
        post_dto.setUpdatedAt(post.getUpdatedAt());
        post_dto.setTime_ago_for_updated_at(post.get_formatted_updated_date());

        Category_id_name_dto category_dto = new Category_id_name_dto();

        category_dto.setId(post.getCategory().getId());
        category_dto.setName(post.getCategory().getName());


        post_dto.setCategory(category_dto);
//        post_dto.setCategory_name(post.getCategory().getName());

        return  post_dto;
    }

    // Convert a list of Post entities to a list of PostDTOs
    public static Post toEntity(Post_dto post_dto) {
        Post post = new Post();
        post.setId(post_dto.getId());
        post.setTitle(post_dto.getTitle());
        post.setContent(post_dto.getContent());
        post.setPhoto_url(post_dto.getPhoto_url());
//        post.setCategory(category);

        Category category = new Category();
        category.setId(post_dto.getId());
        category.setName(post_dto.getCategory().getName());

        post.setCategory(category);

        return post;
    }
}
