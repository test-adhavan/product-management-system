package com.demo.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id ;
    private String name ;
    private Double price;
    private Integer stock;
    private Boolean active;
    private String description;
    private Long categoryId;
  //  private LocalDateTime createdAt;
  //  private LocalDateTime updatedAt;
}
