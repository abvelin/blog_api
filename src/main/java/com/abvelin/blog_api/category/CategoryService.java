package com.abvelin.blog_api.category;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository category_repository;

    public CategoryService(CategoryRepository category_repository){
        this.category_repository = category_repository;
    }

    public Category create_category(Category category) {
//        Category category = CategoryMapper.toEntity(category_dto);
       Category category_created =  category_repository.save(category);

       return category_created;
//        return CategoryMapper.toDto(category);
    }

//    public List<CategoryDto> get_all_categories(){
//        return category_repository.findAll(Sort.by(Sort.Direction.ASC, "displayOrder"));
//    }

//    public List<CategoryDto> get_all_categories(){
//        return category_repository.findAll(Sort.by(Sort.Direction.ASC, "displayOrder"));
//    }

//    public List<Category_dto> get_all_categories(){
//
//        List<Category_dto> categories = category_repository.findAll(Sort.by(Sort.Direction.ASC, "displayOrder"));
////        return categories;
//        return CategoryMapper.toDto(categories);
//    }

    public List<Category_dto> get_all_categories(){
        return category_repository
                .findAll(Sort.by(Sort.Direction.ASC, "displayOrder"))
                .stream().map(Category_mapper::to_category_dto)
                .collect(Collectors.toList());
    }

    public Category_id_name_dto get_category_by_id(int id){
        Category category = category_repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
//        return category;
        return Category_mapper.to_category_id_name_dto(category);
    }

    public Category_with_posts_dto get_category_with_posts(int id) {
        Category category = category_repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        return Category_mapper.to_category_with_posts_dto(category);
    }

    public Category_dto update_category(int id, Category_dto category_dto){

        Category existing_category = category_repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        existing_category.setName(category_dto.getName());
        existing_category.setDisplayOrder(category_dto.getDisplayOrder());

        return Category_mapper.to_category_dto(category_repository.save(existing_category));
    }

    public void delete_category(int id) {
         category_repository.deleteById(id);
//         return category;
    }
}
