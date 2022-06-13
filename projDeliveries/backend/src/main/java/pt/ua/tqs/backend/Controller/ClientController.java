package pt.ua.tqs.backend.Controller;

import pt.ua.tqs.backend.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ClientController {
    @Autowired
    private ClientService cs;
}
