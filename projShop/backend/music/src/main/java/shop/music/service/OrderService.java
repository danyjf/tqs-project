package shop.music.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import shop.music.model.Order;
import shop.music.model.Product;
import shop.music.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    public List<Order> getAll() { return orderRepository.findAll(); }

    public Order createOrder(Order order) {
        Product product = productService.getProductById(order.getProductid());
        if (product.getStock() > 0) {
            product.setStock(product.getStock() - 1);
            return orderRepository.save(order);
        }
        return null;
    }

    public List<Order> getUserOrders(Integer user_id){ return orderRepository.findOrderByUserid(user_id); }

    public Order getOrderById(int id){
        return orderRepository.findById(id);
    }

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

    public Page<Order> getOrdersByUser(int user_id, Pageable pageable){
         return orderRepository.getOrdersByUser(user_id, pageable); 
    }
    
    public String deleteOrder(int id) {
        orderRepository.deleteById(id);
        return "Order (id=" + id + ") removed!";
    }
}
