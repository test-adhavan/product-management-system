package com.demo.product.controller;

import com.demo.product.dto.ProductDto;
import com.demo.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<ProductDto> add(@Valid @RequestBody ProductDto productdto){

        ProductDto dto = service.add(productdto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ProductDto>> getall(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "3") int size){

        Page<ProductDto> dto = service.get(page,size);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        service.delect(id);
       return "Product delected Sucessfully ";
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable Long id , @RequestBody ProductDto productdto){
      ProductDto dto =   service.update(id,productdto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getbyid(@PathVariable Long id){
       ProductDto dto =  service.getbyid(id);
       return ResponseEntity.ok(dto);

    }


    @GetMapping("/category/{id}")
    public ResponseEntity<List<ProductDto>> getbycategory(@PathVariable Long id){
       List<ProductDto> dto =  service.getbycategory(id);
       return ResponseEntity.ok(dto);
    }



}
