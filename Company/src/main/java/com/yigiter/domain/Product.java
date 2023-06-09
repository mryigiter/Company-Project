package com.yigiter.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "t_product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    @NotNull(message = "Product name can not be null")
    private String productName;

    @NotNull(message = "Brand can not be null")
    private String brand;

    @NotNull(message = "Price can not be null")
    private double price;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customers;
}
