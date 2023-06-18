package todoApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import todoApp.model.Order;
import todoApp.services.OrderService;

@RestController
@RequestMapping("api/Order")
public class OrderController {
    
private final OrderService orderService;

 @Autowired
public OrderController (OrderService orderService){
        this.orderService = orderService;
}

@GetMapping("/GetAllOrder")
public ResponseEntity<List<Order>> getallorder(){
    List<Order>  orders = orderService.getAllorder();
      return new ResponseEntity<>(orders, HttpStatus.OK);
}

@PostMapping("/CreateOrder")
  public ResponseEntity<Order> createUser(@RequestBody Order order) {
       Order order2 = orderService.create(order);
        return new ResponseEntity<>(order2 , HttpStatus.CREATED);
    }

@PutMapping("/updateOrder{id}")
public ResponseEntity<Order> updateUser(@PathVariable("id") Long id, @RequestBody Order order) {
    try {
        Order order2= orderService.updatOrder(id, order);
        return new ResponseEntity<>(order2, HttpStatus.OK);
    } catch (IllegalArgumentException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
    }
}

@DeleteMapping("/deleteOrder{id}")
public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
    try {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (IllegalArgumentException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

}
