package com.EcommerceProject.EcommerceProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
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

    @NotBlank(message = "Location name is required.")
    @Size(min = 4, message = "Location name should contain atleast 4 letters.")
    private String location;

    @NotBlank(message = "Phone number is required!")
    @Size(min = 9, message = "Invalid phone number!")
    private String phoneNumber;

    private String status = "ORDER_PLACED";
    private List<ProductQuantity> ProductList = new ArrayList<>();
}
