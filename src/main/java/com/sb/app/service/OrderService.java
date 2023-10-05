package com.sb.app.service;

import com.sb.app.dao.OrderDao;
import com.sb.app.entities.OrderDetails;
import com.sb.app.model.OrderDetailsModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrderDao orderDao;



    public void  saveOrder(OrderDetailsModel orderDetailsModel) {
        log.info("OrderService => saveOrder <= : Starts ");
        OrderDetails dbOrder= new OrderDetails();
        dbOrder.setOrderId(orderDetailsModel.getOrderId());
        dbOrder.setOrderName(orderDetailsModel.getOrderName());
        dbOrder.setOrderPrice(orderDetailsModel.getOrderPrice());
        orderDao.saveOrder(dbOrder);
        log.info("OrderService => saveOrder <= : Ends ");

    }

    public List<OrderDetails> getAll() {
        log.info("OrderService => getAll <= : Starts ");
        log.info("OrderService => getAll <= : Ends ");
        return new ArrayList<>(orderDao.getAll());
    }
    public OrderDetails getById(int id) {
        log.info("OrderService => getAll <= : Starts ");
       // OrderDetails order = new OrderDetails();
       // order = orderDao.getById(id);
        log.info("OrderService => getAll <= : Ends ");
        //return order;
        return orderDao.getById(id);
    }
    public void deleteId(int id){
        orderDao.deleteId(id);
    }

    public void updateOrder(OrderDetailsModel orderDetailsModel) {
        log.info("OrderService => updateOrder <= : Starts ");
        OrderDetails  dbOrder= orderDao.getById(orderDetailsModel.getOrderId());
        dbOrder.setOrderName(orderDetailsModel.getOrderName());
        dbOrder.setOrderPrice(orderDetailsModel.getOrderPrice());
        orderDao.updateOrder(dbOrder);
        log.info("OrderService => updateOrder <= : Ends ");

    }

    public void patchOrder(OrderDetailsModel model, int id) {
        OrderDetails byId = orderDao.getById(id);
        if(byId != null){
            byId.setOrderName(model.getOrderName());
        }
        orderDao.saveOrder(byId);
    }

    public List<OrderDetails> getOrderByName(String  orderName)
    {
        log.info("OrderService => getOrderByName <= : Starts");
        log.info("OrderService => getOrderByName <= : Ends");

        return orderDao.getByName(orderName);
    }
    public List<OrderDetails> getOrderByNameOrPrice(String orderName,int orderPrice){
        log.info("OrderService => getOrderByNameOrPrice <= :Starts");
        log.info("OrderService => getByNameOrPrice <= :Ends");
        return orderDao.getByNameOrPrice(orderName,orderPrice);
    }
    public List<OrderDetails> getOrderIdOrNameOrPrice(int orderId, String orderName, int orderPrice){
        log.info("OrderService => getByIdOrByNameOrPrice <=: Starts");
        log.info("OrderService => getByIdOrByNameOrPrice <=: Ends");
        return orderDao.getByIdOrByNameOrPrice(orderId,orderName,orderPrice);
    }
    public List<OrderDetails> getOrderByPrice(int orderPrice){
        log.info("OrderService =>getOrderByName <=: Starts");
        log.info("OrderService =>getOrderByName <=: Ends");
        return orderDao.getByPrice(orderPrice);
    }
}
