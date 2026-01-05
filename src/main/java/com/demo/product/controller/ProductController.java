package com.demo.product.controller;

import com.demo.product.dto.ProductDto;
import com.demo.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<ProductDto> add(@RequestBody ProductDto productdto){

        ProductDto dto = service.add(productdto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(dto);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getall(){
        List<ProductDto> dto = service.get();
        return ResponseEntity.ok(dto);
    }
}
