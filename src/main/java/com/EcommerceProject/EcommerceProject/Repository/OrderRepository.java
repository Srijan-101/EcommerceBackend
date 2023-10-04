package com.EcommerceProject.EcommerceProject.Repository;

import com.EcommerceProject.EcommerceProject.Model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    Order getOrderById(Integer id);
    Order getOrderByUserId(Integer userId);
}
