package com.EcommerceProject.EcommerceProject.Model.category;


import com.EcommerceProject.EcommerceProject.Model.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

     @Id
     @Column(name = "category_id")
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
     private int id;
     private String type;

     @ManyToOne
     @JoinColumn(name="product_id")
     @JsonIgnore
     private Product product;
}
