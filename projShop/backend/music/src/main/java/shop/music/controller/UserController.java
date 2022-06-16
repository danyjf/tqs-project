package shop.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.music.model.User;
import shop.music.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@CrossOrigin(origins = {"*"})
@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/api/v1/users")
    public Page<User> getAllUsers(Pageable pageable) {
        return userService.getUsers(pageable);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("api/v1/login/{username}/{password}")
    public User login(@PathVariable(value = "username") String username, @PathVariable(value = "password") String password){
        return userService.getUserLogin(username, password);
    }
    @PostMapping("/api/v1/user")
    public User createUsers(@RequestBody User user) {
        return userService.saveUser(user);
    }


    @DeleteMapping("/api/v1/user/{id}")
    public String deleteUsers(@PathVariable(value = "id") int id) {
        return userService.deleteUser(id);
    }


}
