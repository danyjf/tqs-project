package shop.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.music.model.User;
import shop.music.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@CrossOrigin(origins = {"http://127.0.0.1:4200", "http://localhost:4200", "http://deti-tqs-15.ua.pt:7070"})
@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/api/v1/users")
    public Page<User> getAllUsers(Pageable pageable) {
        return userService.getUsers(pageable);
    }

    @PostMapping("/api/v1/user")
    public User createUsers(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/api/v1/user/{id}")
    public String deleteUsers(@PathVariable int id) {
        return userService.deleteUser(id);
    }
}
