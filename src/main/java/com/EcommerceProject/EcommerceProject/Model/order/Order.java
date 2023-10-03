package com.EcommerceProject.EcommerceProject.Model.order;


import com.EcommerceProject.EcommerceProject.Model.User;
import com.EcommerceProject.EcommerceProject.Model.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Order {

     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE)

     @Column(name="Order_id")
     private int id;
     private String Status;
     private LocalDate OrderDate;
     private String Location;

     @ManyToOne()
     private User user;

     @OneToMany()
     private List<Product> productList;

}
