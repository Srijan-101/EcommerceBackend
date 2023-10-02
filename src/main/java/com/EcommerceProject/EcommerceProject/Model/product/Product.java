package com.EcommerceProject.EcommerceProject.Model.product;

import com.EcommerceProject.EcommerceProject.Model.category.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {
    @Id
    private int id;
    private String name;
    private boolean availability;
    private String description;

    @OneToOne
    @JoinColumn(name="category_id")
    private Category category;
}
