package pt.ua.tqs.backend.Controller;

import pt.ua.tqs.backend.Model.User;
import pt.ua.tqs.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{email}/{password}")
    public User getUserByEmailAndPassword(@PathVariable(value = "email") String email, @PathVariable(value = "password") String password) {
        return userService.getUserByEmailAndPassword(email, password);
    }

    @PostMapping("/users")
    public Map<String, String> createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }
}
