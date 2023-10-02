package com.EcommerceProject.EcommerceProject.Model.order;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
     private int Orderid;
     private String Status;
     private LocalDate OrderDate;
     private String Location;

}
