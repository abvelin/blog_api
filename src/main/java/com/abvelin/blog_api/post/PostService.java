package com.abvelin.blog_api.post;

import com.abvelin.blog_api.category.Category;
import com.abvelin.blog_api.category.CategoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

//    @Autowired
    private final PostRepository post_repository;
    private final CategoryRepository category_repository;

    public PostService(PostRepository post_repository, CategoryRepository category_repository){
        this.post_repository = post_repository;
        this.category_repository = category_repository;
    }

    public Post create_post(Post post){
        return post_repository.save(post);
    }

    public List<Post_dto> get_all_posts(){
        List<Post> posts = post_repository.findAll(Sort.by(Sort.Direction.DESC, "updatedAt"));
        return posts.stream()
                .map(PostMapper::toDto)
                .collect(Collectors.toList());
    }

    public Post_dto get_post_by_id(int id){
        Post post = post_repository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));

        return PostMapper.toDto(post);
    }

    public Post_dto update_post(int id, Post_dto post_dto) {
        Post post = post_repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        Category category = category_repository.findById(post_dto.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        post.setTitle(post_dto.getTitle());
        post.setContent(post_dto.getContent());
        post.setPhoto_url(post_dto.getPhoto_url());
        post.setCategory(category);

        return PostMapper.toDto(post_repository.save(post));
    }

//    @Transactional(isolation = Isolation.SERIALIZABLE)  // Adjust the isolation level as needed
//    public Post create_post(Post post) {
//        return post_repository.save(post);
//    }
//
//    public Post update_post(int id, Post post){
//
//        Post existing_post = post_repository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
//
//        existing_post.setTitle(post.getTitle());
//        existing_post.setContent(post.getContent());
//        existing_post.setPhoto_url(post.getPhoto_url());
//        existing_post.setCategory(post.getCategory());
//
//        return post_repository.save(existing_post);
//
//    }
//
    public void delete_post(int id) {
        post_repository.deleteById(id);
    }
}
