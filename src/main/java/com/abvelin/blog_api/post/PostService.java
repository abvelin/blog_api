package com.abvelin.blog_api.post;

import com.abvelin.blog_api.category.Category;
import com.abvelin.blog_api.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository post_repository;

    @Autowired
    private CategoryRepository category_repository;

    public List<Post> get_all_posts(){
        return post_repository.findAll();
    }

    public Post get_post_by_id(int id) {
        return post_repository.findById(id).orElse(null);
    }

//    @Transactional(isolation = Isolation.SERIALIZABLE)  // Adjust the isolation level as needed
    public Post create_post(Post post) {
        return post_repository.save(post);
    }

    public Post update_post(int id, Post post){

        Post existing_post = post_repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));

        existing_post.setTitle(post.getTitle());
        existing_post.setContent(post.getContent());
        existing_post.setPhoto_url(post.getPhoto_url());
        existing_post.setCategory(post.getCategory());

        return post_repository.save(existing_post);

    }

    public void delete_post(int id) {
        post_repository.deleteById(id);
    }
}
