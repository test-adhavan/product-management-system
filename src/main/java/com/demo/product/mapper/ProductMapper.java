package com.demo.product.mapper;

import com.demo.product.dto.ProductDto;
import com.demo.product.entity.Category;
import com.demo.product.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public static Product toproduct(ProductDto productdto, Category category ){
        Product product = new Product();
        product.setName(productdto.getName());
        product.setDescription(productdto.getDescription());
        product.setPrice(productdto.getPrice());
        product.setStock(productdto.getStock());
        product.setActive(productdto.getActive());
        product.setCategory(category);
        return product;
    }
    public static ProductDto toproductdto(Product product){

        ProductDto productdto = new ProductDto();
        productdto.setId(product.getId());
        productdto.setName(product.getName());
        productdto.setDescription(product.getDescription());
        productdto.setPrice(product.getPrice());
        productdto.setStock(product.getStock());
        productdto.setActive(product.getActive());
        productdto.setCategoryId(product.getCategory().getId());
        return productdto;
    }
}
