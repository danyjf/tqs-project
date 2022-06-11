package shop.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.SortDefault;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import shop.music.model.Order;
import shop.music.model.Product;
import shop.music.model.User;
import shop.music.service.OrderService;
import shop.music.service.ProductService;
import shop.music.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://127.0.0.1:4200", "http://localhost:4200", "http://deti-tqs-15.ua.pt:7070"})
@RestController
public class OrderController {

    @Autowired
    private OrderService service;

    @Autowired
    private ProductService productService;
    
    @Autowired
    private UserService userService;

    @GetMapping("api/v1/user/{id}/orders")
    public Page<Order> getUserOrders(@PathVariable int id, 
            @SortDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return service.getOrdersByUser(id, pageable);
    }

    @PostMapping("api/v1/order/{user_id}/{product_id}")
    public Order addFirstProduct(@PathVariable(value = "user_id") Integer user_id, @PathVariable(value = "product_id") Integer product_id) {
        //preco, num,usr
        User usr = userService.getUserById(user_id);
        Product pdt = productService.getProductById(product_id);

        Order odr = new Order(usr);

        odr.addProduct(pdt);

        return service.createOrder(odr); 
    }
}

