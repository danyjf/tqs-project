package shop.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.music.model.Product;
import shop.music.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:5500", "http://deti-tqs-15.ua.pt:5500"})
@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("api/v1/products")
    public List<Product> getAllDailyInfo() { return service.getAll(); }
}
