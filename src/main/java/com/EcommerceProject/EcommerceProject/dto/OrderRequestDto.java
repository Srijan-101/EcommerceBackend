package com.EcommerceProject.EcommerceProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderRequestDto {
    private Integer orderId;
    private Integer userId;
    private String location;
    private String phoneNumber;
    private String status = "ORDER_PLACED";
    private List<ProductQuantity> ProductList = new ArrayList<>();
}
