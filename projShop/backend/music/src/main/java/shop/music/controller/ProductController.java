package shop.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.music.model.Product;
import shop.music.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.data.domain.Sort;


@CrossOrigin(origins = {"*"})
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/api/v1/products")
    public Page<Product> getAllProducts(@SortDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return productService.getProducts(pageable);
    }

    @GetMapping("/api/v1/product/{id}")
    public Product getProduct(@PathVariable int id){
        return productService.getProductById(id);
    }

    @PostMapping("/api/v1/products")
    public Product createProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @DeleteMapping("/api/v1/product/{id}")
    public String deleteUsers(@PathVariable int id) {
        return productService.deleteProduct(id);
    }
}
