package com.EcommerceProject.EcommerceProject.Repository;

import com.EcommerceProject.EcommerceProject.Model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    Order getOrderById(Integer id);
    List<Order> getOrderByUserId(Integer userId);


}
