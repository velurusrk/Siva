package com.sb.app.dao;

import com.sb.app.entities.OrderDetails;
import com.sb.app.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Service
@Slf4j
public class OrderDao {
    @Autowired
    OrderRepository orderRepository;

    public void saveOrder(OrderDetails dbOrder) {
        log.info("OrderDao => saveOrder <= : Starts ");
        orderRepository.save(dbOrder);
        log.info("OrderDao => saveOrder <= : Ends ");
    }
    public List<OrderDetails> getAll() {
        log.info("OrderDao => getAll <= : Starts ");
        log.info("OrderDao => getAll <= : Ends ");
        return new ArrayList<>(orderRepository.findAll());

    }

    public OrderDetails getById(int id) {
        log.info("OrderDao => getAll <= : Starts ");
        OrderDetails orders = new OrderDetails();
        Optional<OrderDetails> order = orderRepository.findById(((Integer) id));
        if (order.isPresent()) {
            orders= order.get();
        }
        log.info("OrderDao => getAll <= : Ends ");
        return orders;
    }
    public void deleteId(int id){
        log.info("OrderDao => getAll <= : Starts ");
        log.info("OrderDao => getAll <= : end");
         orderRepository.deleteById((Integer) id);
    }

    public void updateOrder(OrderDetails dbOrder) {
        log.info("OrderDao => getAll <= : Starts ");
        log.info("OrderDao => getAll <= : end");
        orderRepository.save(dbOrder);
    }
    public List<OrderDetails> getByName(String  orderName) {
        log.info("OrderDao => getByName <= :Starts");
        log.info("OrderDao => getByName <=: Ends");
        return orderRepository.findByName(orderName);
    }

    public List<OrderDetails> getByNameOrPrice(String orderName,int orderPrice){
        log.info("OrderDao => getByNameOrPrice <= : Starts");
        log.info("OrderDao=> getByNameOrPrice <= : Ends");
        return orderRepository.findByNameOrPrice(orderName,orderPrice);
    }
    public List<OrderDetails> getByIdOrByNameOrPrice(int orderId,String orderName,int orderPrice){
        log.info("OrderDao => getByIdOrByNameOrPrice <= : Starts");
        log.info("OrderDao=> getByIdOrByNameOrPrice <= : Ends");
        return  orderRepository.findByIdOrNameOrPrice(orderId,orderName,orderPrice);
    }
    public List<OrderDetails> getByPrice(int orderPrice){
        log.info("OderDao => getByPrice <= : Starts");
        log.info("OrderDao =>getByPrice <= : Ends");

        return orderRepository.findByPrice(orderPrice);
    }
}
