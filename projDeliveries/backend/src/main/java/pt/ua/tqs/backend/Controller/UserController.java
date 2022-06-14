package pt.ua.tqs.backend.controller;

import pt.ua.tqs.backend.service.UserService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService us;
}

