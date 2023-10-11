package com.EcommerceProject.EcommerceProject.Service.order;

import com.EcommerceProject.EcommerceProject.Model.order.Order;
import com.EcommerceProject.EcommerceProject.dto.OrderRequestDto;
import com.EcommerceProject.EcommerceProject.dto.ProductStatus;

import java.util.List;

public interface OrderService {
    String placeOrder(OrderRequestDto orderRequestDto);
    List<Order>  getAllOrder();

    List<Order> getOrderbyUserId(Integer id);

    String updateOrder(ProductStatus productStatus);
}
