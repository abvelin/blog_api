package com.abvelin.blog_api.category;

import com.abvelin.blog_api.post.Post_id_title_dto;

import java.util.List;
import java.util.stream.Collectors;

public class Category_mapper {
    public static Category_dto to_category_dto(Category category){
        Category_dto category_dto = new Category_dto();

        category_dto.setId(category.getId());
        category_dto.setName(category.getName());
        category_dto.setDisplayOrder(category.getDisplayOrder());

        return category_dto;
    }

    public static Category_id_name_dto to_category_id_name_dto(Category category){
        Category_id_name_dto dto = new Category_id_name_dto();

        dto.setId(category.getId());
        dto.setName(category.getName());

        return dto;
    }

    public static Category_with_posts_dto to_category_with_posts_dto(Category category){
        Category_with_posts_dto category_dto = new Category_with_posts_dto();
        category_dto.setId(category.getId());
        category_dto.setName(category.getName());

        List<Post_id_title_dto> posts = category.getPosts().stream()
                .map(post -> {
                    Post_id_title_dto post_dto = new Post_id_title_dto();
                    post_dto.setId(post.getId());
                    post_dto.setTitle(post.getTitle());
                    return post_dto;
                }).collect(Collectors.toList());

        category_dto.setPosts(posts);

        return category_dto;
    }

//    public static Category toEntity(Category_dto category_dto){
//        Category category = new Category();
//        category.setId(category_dto.getId());
//        category.setName(category_dto.getName());
//        category.setDisplayOrder(category_dto.getDisplay_order());
//
//        return category;
//    }
}
