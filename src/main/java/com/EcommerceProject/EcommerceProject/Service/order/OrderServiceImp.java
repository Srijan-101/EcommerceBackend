package com.EcommerceProject.EcommerceProject.Service.order;


import com.EcommerceProject.EcommerceProject.Model.User;
import com.EcommerceProject.EcommerceProject.Model.order.Order;
import com.EcommerceProject.EcommerceProject.Model.product.Product;
import com.EcommerceProject.EcommerceProject.Repository.OrderRepository;
import com.EcommerceProject.EcommerceProject.Repository.ProductRepository;
import com.EcommerceProject.EcommerceProject.Repository.UserRepository;
import com.EcommerceProject.EcommerceProject.dto.OrderRequestDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImp  implements  OrderService{
    private final ProductRepository productRepo;
    private final UserRepository userRepo;

    private final OrderRepository orderRepo;

    public OrderServiceImp(ProductRepository productRepo, UserRepository userRepo, OrderRepository orderRepo) {
        this.productRepo = productRepo;
        this.userRepo = userRepo;
        this.orderRepo = orderRepo;
    }


    @Override
    public String placeOrder(OrderRequestDto orderRequestDto) {
        List<Product> productList = new ArrayList<Product>();

        User user = userRepo.findById(orderRequestDto.getUserId()).orElse(null);
        if (user == null) {
            return "Error";
        }

        orderRequestDto.getProductList().forEach(productQuantity -> {
            Product foundProduct = productRepo.findProductById(productQuantity.getProductId());

            if (foundProduct != null) {
                foundProduct.setQuantity(productQuantity.getQuantity());
                productList.add(foundProduct);
            }
        });

        if (productList.isEmpty()) {
            return "No valid products found";
        }

        Order order = new Order();
        order.setProductList(productList);
        order.setLocation(orderRequestDto.getLocation());
        order.setPhone(orderRequestDto.getPhoneNumber());
        order.setOrderDate(LocalDate.now());
        order.setStatus(orderRequestDto.getStatus());
        order.setUser(user);

        orderRepo.save(order);
        return "Order placed successfully!";
    }

    @Override
    public List<Order> getAllOrder() {
         return orderRepo.findAll();
    }

    @Override
    public List<Order> getOrderbyUserId(Integer id) {
         return  orderRepo.getOrderByUserId(id);
    }


}
