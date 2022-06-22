package pt.ua.tqs.backend.Controller;

import pt.ua.tqs.backend.Model.Order;
import pt.ua.tqs.backend.Service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pt.ua.tqs.backend.Model.Delivery;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class DeliveryController {
    @Autowired
    private DeliveryService ds;

    String[] possibleStatus = new String[] {
        "Waiting for rider",
        "Picking up the order",
        "Delivering the order",
        "Order delivered"
    };
    
    @PostMapping("/delivery")
    public ResponseEntity<Delivery> create_delivery(@RequestBody Delivery delivery){
        //receive information for delivery, send to service, receive delivery and respond
        Delivery d = ds.createDelivery(delivery);
        if(d != null) {
            return ResponseEntity.ok().body(d);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/order")
    public ResponseEntity<Delivery> create_delivery(@RequestBody Order order){
        //receive information for delivery, send to service, receive delivery and respond
        Delivery d = ds.createDeliveryFromOrder(order);
        if(d != null){
            return ResponseEntity.ok().body(d);
        }
        else{
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/deliveries")
    public ResponseEntity<List<Delivery>> listDeliveries() {
        //ask service for deliveries, send response with deliveries
        List<Delivery> ld = ds.listDeliveries();
        return ResponseEntity.ok().body(ld);
    }

    @GetMapping("/deliveries/{id}")
    public ResponseEntity<Delivery> getDelivery(@PathVariable(value = "id") long id){
        //ask service for deliveries, send response with deliveries
        Delivery delivery = ds.getDelivery(id);
        return ResponseEntity.ok().body(delivery);
    }

    @GetMapping("/deliveries/status/{status}")
    public ResponseEntity<List<Delivery>> getDeliveriesWithStatus(@PathVariable(value = "status") String status) {
        List<Delivery> deliveries = ds.getDeliveriesWithStatus(status);
        return ResponseEntity.ok().body(deliveries);
    }

    @GetMapping("/deliveries/filter")
    public ResponseEntity<List<Delivery>> getFilteredDeliveries(@RequestParam List<Boolean> delayed, @RequestParam List<String> store, @RequestParam List<Integer> status) {
        List<String> statusValues = new ArrayList<>();
        for(int i : status) {
            statusValues.add(possibleStatus[i]);
        }
        List<Delivery> deliveries =  ds.getFilteredDeliveries(delayed, store, statusValues);
        return ResponseEntity.ok().body(deliveries);
    }

    @PostMapping("/delivery/rider")
    public ResponseEntity<Delivery> assignToRider(@RequestParam String deliveryId, @RequestParam String riderPhone){
        //send rider and delivery information to service, receive updated delivery and respond
        long delId = Long.parseLong(deliveryId);
        Delivery d = ds.assignToRider(delId, riderPhone);
        if(d != null){
            return ResponseEntity.ok().body(d);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/delivery/rider/status")
    public ResponseEntity<Delivery> getDeliveryByRiderAndStatus(@RequestParam String riderPhone, @RequestParam List<Integer> status) {
        List<String> statusValues = new ArrayList<>();
        for(int i : status) {
            statusValues.add(possibleStatus[i]);
        }
        Delivery delivery = ds.getDeliveryByRiderAndStatus(riderPhone, statusValues);
        return ResponseEntity.ok().body(delivery);
    }

    @PutMapping("/delivery/{id}/status/{status}")
    public ResponseEntity<Delivery> updateDeliveryStatus(@PathVariable(value = "id") long id, @PathVariable(value = "status") String status) {
        //send delivery and status information to service, receive updated delivery and respond
        Delivery d = ds.updateDeliveryStatus(id, status);
        if (d != null) {
            return ResponseEntity.ok().body(d);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
