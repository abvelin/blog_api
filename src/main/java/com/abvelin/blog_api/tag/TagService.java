package com.abvelin.blog_api.tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tag_repository;

    public List<Tag> get_all_tags(){
        return tag_repository.findAll(Sort.by(Sort.Direction.ASC, "displayOrder"));
    }

    public Tag get_tag_by_id(int id) {
        return tag_repository.findById(id).orElse(null);
    }

    public Tag create_tag(Tag category) {
        return tag_repository.save(category);
    }

    public Tag update_tag(int id, Tag category){

        Tag existing_tag = tag_repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        existing_tag.setName(category.getName());
        existing_tag.setDisplayOrder(category.getDisplayOrder());


        return tag_repository.save(existing_tag);

    }

    public void delete_tag(int id) {
        tag_repository.deleteById(id);
//         return category;
    }
}
