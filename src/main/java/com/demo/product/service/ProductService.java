package com.demo.product.service;

import com.demo.product.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto add(ProductDto productdto);

    List<ProductDto> get();

    void delect(Long id);

    ProductDto update(Long id, ProductDto productdto);
}
