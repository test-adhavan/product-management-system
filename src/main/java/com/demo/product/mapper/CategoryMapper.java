package com.demo.product.mapper;

import com.demo.product.dto.CategoryDto;
import com.demo.product.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public static Category tocategory(CategoryDto categorydto){

        Category category = new Category();
        category.setName(categorydto.getName());
        return category;
    }
    public static CategoryDto tocategorydto(Category category){

        CategoryDto categorydto = new CategoryDto();
        categorydto.setId(category.getId());
        categorydto.setName(category.getName());
        return categorydto;
    }

}
