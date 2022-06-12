package shop.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;


import shop.music.model.Order;


// @Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findById(int id);
    //List<Order> findOrderByUserId(Integer user_id);

    @Query(value="SELECT e FROM Orderr e LEFT JOIN User u ON e.user = u WHERE u.id=:u_id", nativeQuery = true)
    Page<Order> getOrdersByUser(@Param("u_id") int u_id, Pageable pageable);

}
