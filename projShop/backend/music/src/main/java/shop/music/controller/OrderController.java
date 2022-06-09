package shop.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.music.model.Order;
import shop.music.model.Product;
import shop.music.service.OrderService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://127.0.0.1:4200", "http://localhost:4200", "http://deti-tqs-15.ua.pt:7070"})
@RestController
public class OrderController {
    @Autowired
    private OrderService service;

    // @GetMapping("api/v1/user/orders/{user_id}")
    // public List<Order> getUserOrders(@PathVariable(value = "user_id") Integer user_id) {
    //     return service.getUserOrders(user_id);
    // }
    // @PostMapping("api/v1/order/{user_id}/{product_id}")
    // public Order addProduct(@PathVariable(value = "user_id") Integer user_id, @PathVariable(value = "product_id") Integer product_id) {
    //     return service.createOrder(new Order(user_id, product_id)); }
}
