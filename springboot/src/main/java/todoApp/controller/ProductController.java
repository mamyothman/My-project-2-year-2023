// package todoApp.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import todoApp.model.Product;

// import todoApp.services.ProductService;
// @CrossOrigin
// @RestController
// @RequestMapping("api/Product")
// public class ProductController {
    
// private final ProductService productService;

//  @Autowired
// public ProductController (ProductService productService){
//         this.productService = productService;
// }

// @GetMapping("/GetAllProduct")
// public ResponseEntity<List<Product>> getallorder(){
//     List<Product>  product = productService.getAllProduct();
//       return new ResponseEntity<>(product, HttpStatus.OK);
// }

// @PostMapping("/CreateProduct")
//   public ResponseEntity<Product> createUser(@RequestBody Product product) {
//        Product product2 = productService.createProduct(product);
//         return new ResponseEntity<>(product2 , HttpStatus.CREATED);
//     }

// @PutMapping("/updateProduct{id}")
// public ResponseEntity<Product> updateUser(@PathVariable("id") Long id, @RequestBody Product product) {
//     try {
//         Product product2= productService.updatProduct(id, product);
//         return new ResponseEntity<>(product2, HttpStatus.OK);
//     } catch (IllegalArgumentException e) {
//         return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
//     }
// }

// @DeleteMapping("/deleteProduct{id}")
// public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
//     try {
//         productService.deleteProduct(id);
//         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//     } catch (IllegalArgumentException e) {
//         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//     }
// }

// }

