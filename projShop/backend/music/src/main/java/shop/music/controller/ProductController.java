package shop.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.music.model.Product;
import shop.music.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://127.0.0.1:4200", "http://localhost:4200", "http://deti-tqs-15.ua.pt:7070"})
@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("api/v1/products")
    public List<Product> getAllDailyInfo() { return service.getAll(); }

    @PostMapping("api/v1/product")
    public Product addProduct(@Valid @RequestBody Product product) {
        return service.createProduct(product); }
}
