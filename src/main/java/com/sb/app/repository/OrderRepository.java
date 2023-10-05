package com.sb.app.repository;

import com.sb.app.entities.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetails, Integer> {


    @Query( value ="select od.order_id, od.order_name, od.order_price from orders od where od.order_Name=:orderName", nativeQuery = true)
    List<OrderDetails> findByName(String orderName);
    @Query( value ="select od.order_id, od.order_name, od.order_price from orders od where od.order_Price=:orderPrice", nativeQuery = true)
    List<OrderDetails> findByPrice(int orderPrice);
    @Query( value ="select od.order_id, od.order_name, od.order_price from orders od where od.order_Name=:orderName OR od.order_Price=:orderPrice", nativeQuery = true)
    List<OrderDetails> findByNameOrPrice(String orderName,int orderPrice);

    @Query( value ="select od.order_id, od.order_name, od.order_price from orders od where od.order_Id=:orderId  OR od.order_Name=:orderName OR od.order_Price=:orderPrice", nativeQuery = true)
    List<OrderDetails> findByIdOrNameOrPrice(int orderId, String orderName, int orderPrice);
}
