package shop.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.music.model.Order;
import shop.music.service.OrderService;

import java.util.List;


@CrossOrigin(origins = {"*"})
@RestController
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping("api/v1/orders")
    public List<Order> getOrders() {
        return service.getAll();
    }

    @GetMapping("api/v1/user/orders/{user_id}")
    public List<Order> getUserOrders(@PathVariable(value = "user_id") Integer user_id) {
        return service.getUserOrders(user_id);
    }

    @PostMapping("api/v1/order/{user_id}")
    public Order addProduct(@PathVariable(value = "user_id") Integer user_id, @RequestParam String products) {
        System.out.println("products: " + products);
        return service.createOrder(user_id, products);}
    @PostMapping("api/v1/order")
    public Order addProduct(@RequestBody Order order) {
        return service.createOrder(order);}

    @DeleteMapping("api/v1/orders")
    public String addProduct() {
        return service.deleteAllOrders();}
}
