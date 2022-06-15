package pt.ua.tqs.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ua.tqs.backend.Repository.*;
import pt.ua.tqs.backend.Model.*;
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
    @Autowired
    private UserRepository ur;

    public DeliveryService(){}

    public DeliveryService(DeliveryRepository dr, ClientRepository cr, StoreRepository sr, UserRepository ur){
        this.dr = dr;
        this.cr = cr;
        this.sr = sr;
        this.ur = ur;
    }
    
    public Delivery createDelivery(String clientPhone, String storePhone, Timestamp orderTime, String orderNote){
        Client c = cr.findByPhone(clientPhone);
        Store s = sr.findByPhone(storePhone);
        if (s == null || c == null){
            return null;
        }
        Delivery d = new Delivery(orderTime, orderNote);
        d.setClient(c);
        d.setStore(s);
        dr.save(d);
        return d;
    //receive delivery information, process and create delivery, save on repository
    }
    
    public List<Delivery> listDeliveries(){
    //get deliveries from repository, send over to controller
        return dr.findAll();
    }
    
    public Delivery assignToRider(long deliveryId, String riderPhone){
    //receive information about the delivery and rider, associate the rider with the delivery, save and send back updated delivery to controller
        
        Delivery d = dr.findById(deliveryId);
        User r = ur.findByPhone(riderPhone);
        if (r == null || !r.getType().equals("Rider") || d.getRider() != null){
            return null;
        }
        d.setRider(r);
        dr.save(d);
        return d;
    }
}
