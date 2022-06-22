package shop.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.music.model.Product;



public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findById(int id);

}