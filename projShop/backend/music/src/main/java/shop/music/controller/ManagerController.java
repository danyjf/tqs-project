package shop.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.music.model.Manager;
import shop.music.service.ManagerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@CrossOrigin(origins = {"http://127.0.0.1:4200", "http://localhost:4200", "http://deti-tqs-15.ua.pt:7070"})
@RestController
public class ManagerController {
    @Autowired
    private ManagerService managerService;


    @GetMapping("/api/v1/managers")
    public Page<Manager> getAllManagers(Pageable pageable) {
        return managerService.getManagers(pageable);
    }

    @PostMapping("/api/v1/manager")
    public Manager createManagers(@RequestBody Manager manager) {
        return managerService.saveManager(manager);
    }

    @DeleteMapping("/api/v1/manager/{id}")
    public String deleteManagers(@PathVariable int id) {
        return managerService.deleteManager(id);
    }

    
}