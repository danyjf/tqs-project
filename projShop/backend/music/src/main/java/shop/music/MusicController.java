package shop.music;

import shop.music.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class MusicController {

    @Autowired
    private UserService userService;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    
}
