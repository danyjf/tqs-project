package pt.ua.tqs.backend.Controller;

import pt.ua.tqs.backend.Model.Store;
import pt.ua.tqs.backend.Service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @PostMapping("/stores")
    public Store createStore(@Valid @RequestBody Store store) {
        return storeService.createStore(store);
    }
}
