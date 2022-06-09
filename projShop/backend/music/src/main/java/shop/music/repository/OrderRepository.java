package shop.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
import shop.music.model.Order;

import java.util.List;

// @Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findById(int id);
    List<Order> findOrderByUserid(Integer user_id);
}
