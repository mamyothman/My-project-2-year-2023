package todoApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todoApp.model.Order;
import todoApp.repository.OrderRepo;
@Service
public class OrderService {
    private final OrderRepo orderRepo;

@Autowired
    public  OrderService(OrderRepo orderRepo){
            this.orderRepo = orderRepo;
    }
// get all order
 public List<Order> getAllorder() {
    return orderRepo.findAll();
 }

//  add order
 public Order create(Order order){
    return orderRepo.save(order);
 }

 //  delete
    public void deleteOrder(long id) {
     orderRepo.deleteById(id);
    }
// update Order
    public Order updatOrder(Long id , Order order){
      Optional<Order> existingOrder = orderRepo.findById((long) id);
        if (existingOrder.isPresent()) {
           Order order2 = existingOrder.get();
           order2.setOrder_name(order.getOrder_name());
            // Update other properties as needed
            return orderRepo.save(order2);
        } else {
            throw new IllegalArgumentException("User with id " + id + " does not exist.");
        }
    }

}
