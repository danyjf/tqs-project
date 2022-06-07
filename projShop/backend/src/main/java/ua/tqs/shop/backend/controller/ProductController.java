package ua.tqs.shop.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import ua.tqs.shop.backend.services.ProductService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:5500", "http://deti-engsoft-08:5500"})
@RestController
public class ProductController {
    @Autowired
    private ProductService service;
}

