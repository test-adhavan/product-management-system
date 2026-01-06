package com.demo.product.controller;

import com.demo.product.dto.CategoryDto;
import com.demo.product.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {


       private final CategoryService service;


        @PostMapping
        public ResponseEntity<String> createCategory(@Valid @RequestBody CategoryDto categorydto){

             service.createCategory(categorydto);
             return  ResponseEntity.status(HttpStatus.CREATED).body("Category Added");
         }

         @GetMapping
         public ResponseEntity<List<CategoryDto>> getAllCategories(){
            List<CategoryDto> dto = service.getAllCategories();
            return ResponseEntity.ok(dto);
         }


}
