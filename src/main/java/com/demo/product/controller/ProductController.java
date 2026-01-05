package com.demo.product.controller;

import com.demo.product.dto.ProductDto;
import com.demo.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService service;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productdto){

        ProductDto dto = service.createProduct(productdto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ProductDto>> getAllProtects(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "3") int size){

        Page<ProductDto> dto = service.getAllProducts(page,size);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        service.deleteProduct(id);
       return "Product delected Sucessfully ";
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id , @RequestBody ProductDto productdto){
      ProductDto dto =   service.updateProduct(id,productdto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id){
       ProductDto dto =  service.getProductById(id);
       return ResponseEntity.ok(dto);

    }


    @GetMapping("/category/{id}")
    public ResponseEntity<List<ProductDto>> getProductsByCategory(@PathVariable Long id){
       List<ProductDto> dto =  service.getProductsByCategory(id);
       return ResponseEntity.ok(dto);
    }



}
