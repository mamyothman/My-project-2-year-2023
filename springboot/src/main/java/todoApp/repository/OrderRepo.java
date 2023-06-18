package todoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import todoApp.model.Order;

public interface OrderRepo extends JpaRepository<Order,Long> {
    
}
