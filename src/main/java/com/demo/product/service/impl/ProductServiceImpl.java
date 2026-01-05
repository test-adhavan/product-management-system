package com.demo.product.service.impl;

import com.demo.product.dto.ProductDto;
import com.demo.product.entity.Category;
import com.demo.product.entity.Product;
import com.demo.product.exception.CategoryNotFound;
import com.demo.product.exception.ProductNotFound;
import com.demo.product.mapper.ProductMapper;
import com.demo.product.repository.CategoryRepository;
import com.demo.product.repository.ProductRepository;
import com.demo.product.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

        Category category = categoryRepository.findById(productdto.getCategoryId()).orElseThrow(() -> new CategoryNotFound("Category doesnt exixts"));

        Product product =  ProductMapper.toproduct(productdto,category);

        return ProductMapper.toproductdto(productRepository.save(product));


    }

    @Override
    public Page<ProductDto> get(int page , int size) {

        Pageable pageable = PageRequest.of(page,size);
        Page<Product> product = productRepository.findAll(pageable);
       Page<ProductDto> dto = product.map(ProductMapper::toproductdto);
       return dto;

    }

    @Override
    public List<ProductDto> getbycategory(Long id) {

        categoryRepository.findById(id).orElseThrow(()-> new CategoryNotFound("Category Not Found"));
        List<Product> product = productRepository.getByCategoryId(id);
      return  product.stream().map(ProductMapper::toproductdto).collect(Collectors.toList());
    }

    @Override
    public void delect(Long id) {
      Product product =  productRepository.findById(id).orElseThrow(() -> new ProductNotFound("Product Not Found"));
       productRepository.delete(product);
    }

    @Override
    public ProductDto update(Long id, ProductDto dto) {
        Product product = productRepository.findById(id).orElseThrow(()-> new ProductNotFound("Product Not Found"));

        if(dto.getCategoryId()!=null) {
            Category category = categoryRepository.findById(dto.getCategoryId()).orElseThrow(() -> new CategoryNotFound("Category Not Found"));
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

    @Override
    public ProductDto getbyid(Long id) {
        Product product = productRepository.findById(id).orElseThrow(()-> new ProductNotFound("Product Not found"));
        return ProductMapper.toproductdto(product);
    }


}
