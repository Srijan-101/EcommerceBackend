package com.EcommerceProject.EcommerceProject.Controller;


import com.EcommerceProject.EcommerceProject.Service.order.OrderService;
import com.EcommerceProject.EcommerceProject.dto.ApiResponse;
import com.EcommerceProject.EcommerceProject.dto.OrderRequestDto;
import com.EcommerceProject.EcommerceProject.dto.ProductStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderservice;

    public OrderController(OrderService orderservice) {
        this.orderservice = orderservice;
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<ApiResponse> placeOrder(@RequestBody @Valid OrderRequestDto orderRequest){
        return ResponseEntity.ok(
                new ApiResponse(true,
                        "Order created sucessfully!",
                        orderservice.placeOrder(orderRequest)));
    }

    @GetMapping("/GetAll")
    public ResponseEntity<ApiResponse> GetOrder(){
        return ResponseEntity.ok(
                new ApiResponse(true,
                        "sucessfully fetched!",
                        orderservice.getAllOrder()));
    }

    @PutMapping("/updateStatus")
    public ResponseEntity<ApiResponse> updateStatus(@RequestBody ProductStatus productStatus){
        return ResponseEntity.ok(
                new ApiResponse(true,
                        "sucessfully updated!",
                        orderservice.updateOrder(productStatus)));
    }

    @GetMapping("/getOrderByUser/{id}")
    public ResponseEntity<ApiResponse> getOrderByUserId(@PathVariable Integer id){
        return ResponseEntity.ok(
                new ApiResponse(true,
                        "sucessfully fetched",
                        orderservice.getOrderbyUserId(id)));
    }

}
