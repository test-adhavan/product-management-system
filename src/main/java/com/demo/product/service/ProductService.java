package com.demo.product.service;

import com.demo.product.dto.ProductDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ProductDto add(ProductDto productdto);

    void delect(Long id);

    ProductDto update(Long id, ProductDto productdto);

    ProductDto getbyid(Long id);

    Page<ProductDto> get(int page, int size);

    List<ProductDto> getbycategory(Long id);
}
