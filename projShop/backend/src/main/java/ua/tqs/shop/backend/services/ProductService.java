package ua.tqs.shop.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.tqs.shop.backend.model.Product;
import ua.tqs.shop.backend.repository.ProductRepository;

import java.util.List;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() { return productRepository.findAll(); }

    public Product createDailyInfo(Product daily) { return productRepository.save(daily); }
}