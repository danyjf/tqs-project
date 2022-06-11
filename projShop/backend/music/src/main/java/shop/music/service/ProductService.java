package shop.music.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import shop.music.model.Product;
import shop.music.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(int id){
        return productRepository.findById(id);
    }

    public List<Product> getAll() { return productRepository.findAll(); }

    public Product createProduct(Product product) { return productRepository.save(product); }
}
