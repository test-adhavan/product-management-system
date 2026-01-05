package com.demo.product.mapper;

import com.demo.product.dto.CategoryDto;
import com.demo.product.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public static Category toCategory(CategoryDto categorydto){

        Category category = new Category();
        category.setName(categorydto.getName());
        return category;
    }
    public static CategoryDto toCategoryDto(Category category){

        CategoryDto categorydto = new CategoryDto();
        categorydto.setId(category.getId());
        categorydto.setName(category.getName());
        return categorydto;
    }

}
