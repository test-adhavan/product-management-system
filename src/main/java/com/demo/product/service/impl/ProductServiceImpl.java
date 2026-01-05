package com.demo.product.service.impl;

import com.demo.product.dto.ProductDto;
import com.demo.product.entity.Category;
import com.demo.product.entity.Product;
import com.demo.product.mapper.ProductMapper;
import com.demo.product.repository.CategoryRepository;
import com.demo.product.repository.ProductRepository;
import com.demo.product.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ProductDto add(ProductDto productdto) {

        Category category = categoryRepository.findById(productdto.getCategoryId())
                 .orElseThrow(() -> new EntityNotFoundException());

        Product product =  ProductMapper.toproduct(productdto,category);

        return ProductMapper.toproductdto(productRepository.save(product));


    }

    @Override
    public List<ProductDto> get() {
        List<Product> product = productRepository.findAll();
        List<ProductDto> dto = product.stream()
                .map(ProductMapper::toproductdto)
                .collect(Collectors.toList());
        return dto;

    }

    @Override
    public void delect(Long id) {
      Product product =  productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
       productRepository.delete(product);
    }

    @Override
    public ProductDto update(Long id, ProductDto dto) {
        Product product = productRepository.findById(id).orElseThrow(()-> new EntityNotFoundException());

        if(dto.getCategoryId()!=null) {
            Category category = categoryRepository.findById(dto.getCategoryId()).orElseThrow(() -> new EntityNotFoundException());
            product.setCategory(category);
        }

        if(dto.getName()!=null  && !dto.getName().isBlank()) product.setName(dto.getName());
        if(dto.getDescription()!=null && !dto.getDescription().isBlank()) product.setDescription(dto.getDescription());
        if(dto.getActive()!=null) product.setActive(dto.getActive());
        if(dto.getStock()!=null) product.setStock(dto.getStock());
        if(dto.getPrice()!=null) product.setPrice(dto.getPrice());


        Product updatedproduct = productRepository.save(product);

           return ProductMapper.toproductdto(updatedproduct);

    }


}
