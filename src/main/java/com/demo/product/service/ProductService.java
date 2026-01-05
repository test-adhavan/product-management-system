package com.demo.product.service;

import com.demo.product.dto.ProductDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productdto);

    void deleteProduct(Long id);

    ProductDto updateProduct(Long id, ProductDto productdto);

    ProductDto getProductById(Long id);

    Page<ProductDto> getAllProducts(int page, int size);

    List<ProductDto> getProductsByCategory(Long id);
}
