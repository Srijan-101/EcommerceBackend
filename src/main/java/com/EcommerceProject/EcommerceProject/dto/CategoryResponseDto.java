package com.EcommerceProject.EcommerceProject.dto;


import com.EcommerceProject.EcommerceProject.Model.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDto {
    private Integer id;
    private String type;
    private List<Product> ProductList;
}
