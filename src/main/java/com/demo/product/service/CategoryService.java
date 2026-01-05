package com.demo.product.service;

import com.demo.product.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    void createCategory(CategoryDto categorydto);

    List<CategoryDto> getAllCategories();
}
