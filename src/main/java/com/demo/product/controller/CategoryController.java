package com.demo.product.controller;

import com.demo.product.dto.CategoryDto;
import com.demo.product.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

       @Autowired
       private CategoryService service;


        @PostMapping
        public ResponseEntity<String> Createcategory(@Valid @RequestBody CategoryDto categorydto){

             service.add(categorydto);
             return  ResponseEntity.status(HttpStatus.CREATED).body("Category Added");
         }

         @GetMapping
         public ResponseEntity<List<CategoryDto>> getcategory(){
            List<CategoryDto> dto = service.get();
            return ResponseEntity.ok(dto);
         }


}
