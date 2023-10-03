package com.EcommerceProject.EcommerceProject.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductRequestDto {
    private Integer id;
    private String name;
    private Double price;
    private boolean availability = true;
    private String description;
    private Integer Category_id;
}
