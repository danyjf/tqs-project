package pt.ua.tqs.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pt.ua.tqs.backend.Service.DeliveryService;
import pt.ua.tqs.backend.Model.Delivery;
import pt.ua.tqs.backend.Model.User;

import java.util.List;

@RestController
@RequestMapping("/")
public class DeliveryController {
    @Autowired
    private DeliveryService ds;
    
    @PostMapping("/delivery")
    public ResponseEntity<Delivery> create_delivery(){
    //receive information for delivery, send to service, receive delivery and respond
        return null;
    }

    @GetMapping("/deliveries")
    public ResponseEntity<List<Delivery>> list_deliveries(){
    //ask service for deliveries, send response with deliveries
        return null;
    }
    
    @PostMapping("/delivery/rider")
    public ResponseEntity<Delivery> assign_to_rider(){
    //send rider and delivery information to service, receive updated delivery and respond
        return null;
    }
}
