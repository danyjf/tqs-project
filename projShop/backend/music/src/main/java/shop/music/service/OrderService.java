package shop.music.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.music.model.Order;
import shop.music.model.Product;
import shop.music.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() { return orderRepository.findAll(); }

    public Order createOrder(Order order) { return orderRepository.save(order); }

    public List<Order> getUserOrders(Integer user_id){ return orderRepository.findOrderByUserid(user_id); }
}
