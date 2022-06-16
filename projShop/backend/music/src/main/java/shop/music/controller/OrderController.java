package shop.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.SortDefault;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import shop.music.model.Order;
import shop.music.model.Product;
import shop.music.service.OrderService;
import shop.music.service.ProductService;
import shop.music.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


@CrossOrigin(origins = {"*"})
@RestController
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping("api/v1/user/orders/{user_id}")
    public List<Order> getUserOrders(@PathVariable(value = "user_id") Integer user_id) {
        return service.getUserOrders(user_id);
    }
    @PostMapping("api/v1/order/{user_id}/{product_id}")
    public Order addProduct(@PathVariable(value = "user_id") Integer user_id, @PathVariable(value = "product_id") Integer product_id) {
        return service.createOrder(new Order(user_id, product_id)); }
}

/**
@CrossOrigin(origins = {"http://127.0.0.1:4200", "http://localhost:4200", "http://deti-tqs-15.ua.pt:7070"})
@RestController
public class OrderController {

    @Autowired
    private OrderService service;

    @Autowired
    private ProductService productService;
    
    @Autowired
    private UserService userService;


    @GetMapping("/api/v1/order/{id}")
    public Order getOrder(@PathVariable int id) {
        return service.getOrderById(id);
    }

    @PostMapping("/api/v1/order")
    public Order createOrder(@RequestBody Order order) {
        return service.saveOrder(order);
    }

    @DeleteMapping("/api/v1/order/{id}")
    public String deleteOrder(@PathVariable int id) {
        return service.deleteOrder(id);
    }

    @GetMapping("/api/v1/user/{id}/orders")
    public Page<Order> getUserOrders(@PathVariable int id, 
            @SortDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return service.getOrdersByUser(id, pageable);
    }

    @PostMapping("/api/v1/order/{order_id}/add/{product_id}")
    public Order addProduct(@PathVariable(value = "order_id") Integer order_id, @PathVariable(value = "product_id") Integer product_id) {
        
        Order order = service.getOrderById(order_id);
        Product pdt = productService.getProductById(product_id);

        order.addProduct(pdt);

        return service.saveOrder(order); 
    }

    @PostMapping("/api/v1/order/{order_id}/remove/{product_id}")
    public Order removeProduct(@PathVariable(value = "order_id") Integer order_id, @PathVariable(value = "product_id") Integer product_id) {
        
        Order order = service.getOrderById(order_id);
        Product pdt = productService.getProductById(product_id);

        order.removeProduct(pdt);

        return service.saveOrder(order); 
    }
}
**/
