package pt.ua.tqs.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ua.tqs.backend.Repository.*;
import pt.ua.tqs.backend.Model.Delivery;
import pt.ua.tqs.backend.Model.User;
import java.sql.Timestamp;

import java.util.List;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository dr;
    @Autowired
    private ClientRepository cr;
    @Autowired
    private StoreRepository sr;

    public DeliveryService(){}

    public DeliveryService(DeliveryRepository dr, ClientRepository cr, StoreRepository sr){
        this.dr = dr;
        this.cr = cr;
        this.sr = sr;
    }
    
    public Delivery create_delivery(String client_phone, String store_phone, Timestamp orderTime, String orderNote){
        return null;
    //receive delivery information, process and create delivery, save on repository
    }
    
    public List<Delivery> list_deliveries(){
    //get deliveries from repository, send over to controller
        return null;
    }
    
    public Delivery assign_to_rider(){
    //receive information about the delivery and rider, associate the rider with the delivery, save and send back updated delivery to controller
        return null;
    }
}
