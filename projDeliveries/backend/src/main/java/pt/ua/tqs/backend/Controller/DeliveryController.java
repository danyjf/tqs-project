package pt.ua.tqs.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pt.ua.tqs.backend.Service.DeliveryService;
import pt.ua.tqs.backend.Model.Delivery;

import java.sql.Timestamp;
import java.util.List;


@RestController
@RequestMapping("/")
public class DeliveryController {
    @Autowired
    private DeliveryService ds;
    
    @PostMapping("/delivery")
    public ResponseEntity<Delivery> create_delivery(@RequestBody String client_phone, @RequestBody String store_phone, @RequestBody String orderTime, @RequestBody String orderNote){
    //receive information for delivery, send to service, receive delivery and respond
        Timestamp orderTimestamp = Timestamp.valueOf(orderTime);
        Delivery d = ds.create_delivery(client_phone, store_phone, orderTimestamp, orderNote);
        if(d != null){
            return ResponseEntity.ok().body(d);
        }
        else{
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/deliveries")
    public ResponseEntity<List<Delivery>> list_deliveries(){
    //ask service for deliveries, send response with deliveries
        List<Delivery> ld = ds.list_deliveries();
        return ResponseEntity.ok().body(ld);
    }
    
    @PostMapping("/delivery/rider")
    public ResponseEntity<Delivery> assign_to_rider(@RequestBody long delivery_id, @RequestBody String rider_phone){
    //send rider and delivery information to service, receive updated delivery and respond
        Delivery d = ds.assign_to_rider(delivery_id, rider_phone);
        if(d != null){
            return ResponseEntity.ok().body(d);
        }
        else{
            return ResponseEntity.badRequest().body(null);
        }
    }
}
