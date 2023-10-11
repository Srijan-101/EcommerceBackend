package com.EcommerceProject.EcommerceProject.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
public class ProductRequestDto {
    private Integer id;

    @NotBlank(message = "Product name is required.")
    @Size(min = 4, message = "Product name should contain atleast 2 letters.")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Product name should only contain alphabetic characters.")
    private String name;

    @NotNull(message = "Price cannot be null")
    @Min(value = 1, message = "Price must be at least 1")
    private Double price;
    private boolean availability = true;
    private String description;

    @NotNull(message = "Category cannot be null")
    private Integer Category_id;
}
