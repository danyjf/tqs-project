package pt.ua.tqs.backend.Controller;

import pt.ua.tqs.backend.Service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pt.ua.tqs.backend.Model.Delivery;

import java.sql.Timestamp;
import java.util.List;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class DeliveryController {
    @Autowired
    private DeliveryService ds;
    
    @PostMapping("/delivery")
//    public ResponseEntity<Delivery> create_delivery(@RequestBody String clientName, @RequestBody String clientAddress, @RequestBody String clientPhone, @RequestBody String storePhone, @RequestBody String orderTime, @RequestBody String orderNote){
    public ResponseEntity<Delivery> create_delivery(@RequestBody Delivery delivery){
    //receive information for delivery, send to service, receive delivery and respond
//        System.out.println(orderTime);
//        Timestamp orderTimestamp = Timestamp.valueOf(orderTime);
//        Delivery d = ds.createDelivery(clientName, clientAddress, clientPhone, storePhone, orderTimestamp, orderNote);
//        if(d != null){
//            return ResponseEntity.ok().body(d);
//        }
//        else{
//            return ResponseEntity.badRequest().body(null);
//        }

        Delivery d = ds.createDelivery(delivery);
        if(d != null){
            return ResponseEntity.ok().body(d);
        }
        else{
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/deliveries")
    public ResponseEntity<List<Delivery>> listDeliveries(){
    //ask service for deliveries, send response with deliveries
        List<Delivery> ld = ds.listDeliveries();
        return ResponseEntity.ok().body(ld);
    }
    
    @PostMapping("/delivery/rider")
    public ResponseEntity<Delivery> assignToRider(@RequestParam String deliveryId, @RequestParam String riderPhone){
    //send rider and delivery information to service, receive updated delivery and respond
        long delId = Long.parseLong(deliveryId);
        Delivery d = ds.assignToRider(delId, riderPhone);
        if(d != null){
            return ResponseEntity.ok().body(d);
        }
        else{
            return ResponseEntity.badRequest().body(null);
        }
    }
}
