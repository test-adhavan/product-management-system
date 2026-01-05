package com.demo.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id ;
    @NotBlank(message = "Name Field Required")
    private String name ;
    @Positive(message = "price should greater than zero ")
    @NotNull(message = "price field required")
    private Double price;
    @PositiveOrZero(message = "Stock should be zero or positive value")
    private Integer stock;
    private Boolean active;
    private String description;
    @NotNull(message = "Categoryid Field Required")
    private Long categoryId;
  //  private LocalDateTime createdAt;
  //  private LocalDateTime updatedAt;
}
