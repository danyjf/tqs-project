package pt.ua.tqs.backend.Controller;

import pt.ua.tqs.backend.Service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class DeliveryController {
    @Autowired
    private DeliveryService ds;
}
