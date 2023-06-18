package todoApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todoApp.model.Product;
import todoApp.repository.ProductRepo;

@Service
public class ProductService {
    private final ProductRepo productRepo;

@Autowired
    public  ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }
// get all product
 public List<Product> getAllProduct() {
    return productRepo.findAll();
 }

//  add product
 public Product createProduct(Product product){
    return productRepo.save(product);
 }

 //  delete
    public void deleteProduct(long id) {
     productRepo.deleteById(id);
    }
// update Product
    public Product updatProduct(Long id , Product product){
      Optional<Product> existingProduct = productRepo.findById((long) id);
        if (existingProduct.isPresent()) {
           Product product2 = existingProduct.get();
           product2.setProduct_name(product.getProduct_name());
            // Update other properties as needed
            return productRepo.save(product2);
        } else {
            throw new IllegalArgumentException("User with id " + id + " does not exist.");
        }
    }


}
