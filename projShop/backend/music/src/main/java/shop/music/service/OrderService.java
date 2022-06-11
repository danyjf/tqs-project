package shop.music.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import shop.music.model.Order;
import shop.music.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() { return orderRepository.findAll(); }

    public Order createOrder(Order order) { return orderRepository.save(order); }

    public Page<Order> getOrdersByUser(int user_id, Pageable pageable){
         return orderRepository.getOrdersByUser(user_id, pageable); 
        }
    
}
