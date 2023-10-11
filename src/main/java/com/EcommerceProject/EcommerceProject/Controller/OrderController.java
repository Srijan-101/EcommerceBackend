package com.EcommerceProject.EcommerceProject.Controller;


import com.EcommerceProject.EcommerceProject.Service.order.OrderService;
import com.EcommerceProject.EcommerceProject.dto.ApiResponse;
import com.EcommerceProject.EcommerceProject.dto.OrderRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderservice;

    public OrderController(OrderService orderservice) {
        this.orderservice = orderservice;
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<ApiResponse> placeOrder(@RequestBody OrderRequestDto orderRequest){
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

}
