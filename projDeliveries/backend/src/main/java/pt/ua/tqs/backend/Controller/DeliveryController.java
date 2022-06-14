package pt.ua.tqs.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import ResponseEntity 

import pt.ua.tqs.backend.service.DeliveryService;
import pt.ua.tqs.backend.Model.Delivery;
import pt.ua.tqs.backend.Model.User;

import java.util.List;

@RestController
@RequestMapping("/")
public class DeliveryController {
    @Autowired
    private DeliveryService ds;
    
    public ResponseEntity<Delivery> create_delivery(){
    //receive information for delivery, send to service, receive delivery and respond
    
    }
    
    public ResponseEntity<List<Delivery>> list_deliveries(){
    //ask service for deliveries, send response with deliveries
    }
    
    public ResponseEntity<Delivery> assign_to_rider(){
    //send rider and delivery information to service, receive updated delivery and respond
    
    }
}
