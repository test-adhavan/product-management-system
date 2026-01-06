package com.demo.product.service.impl;

import com.demo.product.dto.ProductDto;
import com.demo.product.entity.Category;
import com.demo.product.entity.Product;
import com.demo.product.exception.CategoryNotFoundException;
import com.demo.product.exception.ProductNotFoundException;
import com.demo.product.mapper.ProductMapper;
import com.demo.product.repository.CategoryRepository;
import com.demo.product.repository.ProductRepository;
import com.demo.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    @Override
    public ProductDto createProduct(ProductDto productdto) {

        Category category = categoryRepository.findById(productdto.getCategoryId()).orElseThrow(() ->
                new CategoryNotFoundException("Category not found"));

        Product product =  ProductMapper.toProduct(productdto,category);

        return ProductMapper.toProductDto(productRepository.save(product));


    }

    @Override
    public Page<ProductDto> getAllProducts(int page , int size) {

        Pageable pageable = PageRequest.of(page,size);
        Page<Product> product = productRepository.findAll(pageable);
       Page<ProductDto> dto = product.map(ProductMapper::toProductDto);
       return dto;

    }

    @Override
    public List<ProductDto> getProductsByCategory(Long id) {

        categoryRepository.findById(id).orElseThrow(()-> new CategoryNotFoundException("Category not Found"));
        List<Product> product = productRepository.findByCategoryId(id);
      return  product.stream().map(ProductMapper::toProductDto).collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(Long id) {
      Product product =  productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not Found"));
       productRepository.delete(product);
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto dto) {
        Product product = productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product not Found"));

        if(dto.getCategoryId()!=null) {
            Category category = categoryRepository.findById(dto.getCategoryId()).orElseThrow(() -> new CategoryNotFoundException("Category Not Found"));
            product.setCategory(category);
        }

        if(dto.getName()!=null  && !dto.getName().isBlank()) product.setName(dto.getName());
        if(dto.getDescription()!=null && !dto.getDescription().isBlank()) product.setDescription(dto.getDescription());
        if(dto.getActive()!=null) product.setActive(dto.getActive());
        if(dto.getStock()!=null) product.setStock(dto.getStock());
        if(dto.getPrice()!=null) product.setPrice(dto.getPrice());


        Product updatedproduct = productRepository.save(product);

           return ProductMapper.toProductDto(updatedproduct);

    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product Not found"));
        return ProductMapper.toProductDto(product);
    }


}
