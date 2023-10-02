package com.EcommerceProject.EcommerceProject.Model.category;


import com.EcommerceProject.EcommerceProject.Model.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

     @Id
     private int CategoryId;
     private String type;

     @ManyToOne
     @JoinColumn(name="product_id")
     private Product product;
}
