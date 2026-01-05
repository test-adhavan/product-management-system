package com.demo.product.service.impl;

import com.demo.product.dto.CategoryDto;
import com.demo.product.entity.Category;
import com.demo.product.mapper.CategoryMapper;
import com.demo.product.repository.CategoryRepository;
import com.demo.product.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;


    @Override
    public void createCategory(CategoryDto categorydto) {

        Category category = CategoryMapper.toCategory(categorydto);

        repository.save(category);

    }

    @Override
    public List<CategoryDto> getAllCategories() {

        List<Category> category = repository.findAll();

        List<CategoryDto> dto =  category.stream()
               .map(CategoryMapper::toCategoryDto)
               .collect(Collectors.toList());
       return dto ;
    }
}
