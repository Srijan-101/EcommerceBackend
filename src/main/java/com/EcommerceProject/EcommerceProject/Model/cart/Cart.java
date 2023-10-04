package com.EcommerceProject.EcommerceProject.Model.cart;


import com.EcommerceProject.EcommerceProject.Model.User;
import com.EcommerceProject.EcommerceProject.Model.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
     private Integer id;

     @OneToOne()
     private User user;

     @OneToMany()
     @JoinColumn(name="product_id")
     private List<Product> productList;
}
