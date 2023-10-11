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
@Table(name = "order_table")
public class Order {

     @Id
     @Column(name="order_id")
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
     private int id;

     private String Status;
     private LocalDate OrderDate;
     private String Location;
     private String Phone;

     @ManyToOne()
     @JoinColumn(name = "user_id")
     private User user;

     @OneToMany(cascade = CascadeType.PERSIST)
     private List<Product> productList;

}
