package com.abvelin.blog_api.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository category_repository;

    public List<Category> get_all_categories(){
        return category_repository.findAll(Sort.by(Sort.Direction.ASC, "displayOrder"));
    }

    public Category get_category_by_id(int id) {
        return category_repository.findById(id).orElse(null);
    }

    public Category create_category(Category category) {
        return category_repository.save(category);
    }

    public Category update_category(int id, Category category){

        Category existing_category = category_repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        existing_category.setName(category.getName());
        existing_category.setDisplayOrder(category.getDisplayOrder());


        return category_repository.save(existing_category);

    }

    public void delete_category(int id) {
         category_repository.deleteById(id);
//         return category;
    }
}
