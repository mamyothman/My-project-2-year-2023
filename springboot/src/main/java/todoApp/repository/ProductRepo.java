package todoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import todoApp.model.Product;

public interface ProductRepo extends JpaRepository<Product,Long> {
    
}
