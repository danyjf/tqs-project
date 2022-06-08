package shop.music.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.music.model.Product;
import shop.music.repository.ProductRepository;

import java.util.List;
@Service
public class ProductService {
    //@Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() { return productRepository.findAll(); }

    public Product createDailyInfo(Product daily) { return productRepository.save(daily); }
}
