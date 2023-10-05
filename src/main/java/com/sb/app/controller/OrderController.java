package com.sb.app.controller;


import com.sb.app.entities.OrderDetails;
import com.sb.app.exception.OrderNotFoundException;
import com.sb.app.model.OrderDetailsModel;
import com.sb.app.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class OrderController {


    @Autowired
    private OrderService orderService;



    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<OrderDetails> saveOrder(@RequestBody OrderDetailsModel orderDetailsModel) {
        log.info("OrderController => saveOrder <= : Starts ");
        orderService.saveOrder(orderDetailsModel);
        log.info("OrderController => saveOrder <= : Ends ");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @RequestMapping(value="/getAll" ,method=RequestMethod.GET)
    public ResponseEntity<List<OrderDetails>> retrieveAll(){
        log.info("OrderController => retrieveAll <= : Starts ");
        List<OrderDetails> orderDetailsList= orderService.getAll();
        log.info("OrderController => retrieveAll <= : Ends ");
        return new ResponseEntity<>(orderDetailsList,HttpStatus.OK);
    }
    @RequestMapping(value="/getById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<OrderDetails>getById(@PathVariable int id){

        log.info("OrderController => retrieveAll <= : Starts ");
        log.info("OrderController => retrieveAll <= : Ends ");
        OrderDetails byId = orderService.getById(id);
        if(byId.getOrderName() != null){
            return new ResponseEntity<>(byId, HttpStatus.OK);
        }else{
            throw new OrderNotFoundException();
        }
        //return new ResponseEntity<>(orderService.getById(id),HttpStatus.OK);
    }

    @RequestMapping(value="/deleteById/{id}")
    public  ResponseEntity<Object> deleteById(@PathVariable int id)
    {
        log.info("OrderController => deleteAll <= : Start ");
        orderService.deleteId(id);
        log.info("OrderController => deleteAll <= : end ");
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value="/updateOrder", method = RequestMethod.PUT)
    public ResponseEntity<OrderDetails> updateOrder(@RequestBody OrderDetailsModel model){
        log.info("OrderController => deleteAll <= : Start ");
        orderService.updateOrder(model);
        log.info("OrderController => deleteAll <= : end ");
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value ="/patchOrder/{id}",method = RequestMethod.PATCH)
    public ResponseEntity<OrderDetails>patchOrder(@RequestBody OrderDetailsModel model,@PathVariable int id)
    {
        orderService.patchOrder(model,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/getByName/{orderName}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<OrderDetails>> getByName(@PathVariable String orderName) {
        log.info("OrderController => getByName <= : Starts");
        List<OrderDetails> orderByName = orderService.getOrderByName(orderName);
        log.info("OrderController => getByName <= :Ends");
        return new ResponseEntity<>(orderByName, HttpStatus.OK);

    }
    @RequestMapping(value = "/getByPrice/{orderPrice}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<OrderDetails>> getByPrice(@PathVariable int orderPrice){
        log.info("OrderController => getByPrice <= :Starts ");
        List<OrderDetails> orderByPrice = orderService.getOrderByPrice(orderPrice);
        log.info("OrderController => getByPrice <= :Ends");
        return new ResponseEntity<>(orderByPrice,HttpStatus.OK);
    }
    @RequestMapping(value = "/getByNameOrPrice/{orderName}/{orderPrice}",method =RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<OrderDetails>> getByNameOrPrice(@PathVariable String orderName,@PathVariable int orderPrice){
        log.info("OrderController => getByNameOrPrice <=: Starts");
        List<OrderDetails> orderByNameOrByPrice = orderService.getOrderByNameOrPrice(orderName,orderPrice);
        log.info("OrderController => getByNameOrPrice <=: Ends");
        return  new ResponseEntity<>(orderByNameOrByPrice,HttpStatus.OK);
    }
    @RequestMapping(value = "/getByIdOrNameOrPrice/{orderId}/{orderName}/{orderPrice}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<OrderDetails>> getByIdOrNameOrPrice(@PathVariable int orderId,@PathVariable String orderName,@PathVariable int orderPrice){
        log.info("OrderController =>getByIdOrNameOrPrice <=:Starts");
        List<OrderDetails> orderByIdOrNameOrPrice =orderService.getOrderIdOrNameOrPrice(orderId,orderName,orderPrice);
        log.info("OrderController =>getByIdOrNameOrPrice <=:Ends");
        return  new ResponseEntity<>(orderByIdOrNameOrPrice,HttpStatus.ACCEPTED);
    }

}
