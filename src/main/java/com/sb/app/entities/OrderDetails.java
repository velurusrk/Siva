package com.sb.app.entities;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "Orders")
public class OrderDetails {



//    @GeneratedValue(strategy = GenerationType.AUTO)
     @Id
    @Column(name = "orderId",unique = true)
    private int orderId;



    @Column(name = "orderName")
    private String orderName;

    @Column(name = "orderPrice")
    private int orderPrice;



}
