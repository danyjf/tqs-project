package pt.ua.tqs.backend.controller;

import pt.ua.tqs.backend.service.StoreService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class StoreController {
    @Autowired
    private StoreService ss;
}
