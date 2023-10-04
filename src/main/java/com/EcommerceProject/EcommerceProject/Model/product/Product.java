package com.EcommerceProject.EcommerceProject.Model.product;

import com.EcommerceProject.EcommerceProject.Model.cart.Cart;
import com.EcommerceProject.EcommerceProject.Model.category.Category;
import com.EcommerceProject.EcommerceProject.Model.order.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @Column(name="product_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private Double price;

    private boolean availability = true;
    private String description;

    @ManyToOne()
    @JoinColumn(name="category_id")
    @NotNull(message = "Please select category")
    private Category category;

}
