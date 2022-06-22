package pt.ua.tqs.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ua.tqs.backend.Config.CustomMessage;
import pt.ua.tqs.backend.Config.MessagePublisher;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Autowired
    private MessagePublisher publisher;

    public DeliveryService(){}

    public DeliveryService(DeliveryRepository dr, ClientRepository cr, StoreRepository sr, UserRepository ur){
        this.dr = dr;
        this.cr = cr;
        this.sr = sr;
        this.ur = ur;
    }

    public Delivery createDeliveryFromOrder(Order order){
        Delivery delivery = new Delivery(order.getOrderTime(), sr.findByPhone(order.getStorePhone()), new Client(order.getClientName(), order.getDeliveryAddress(), order.getClientPhone()), order.getOrderNote());
        String storeIdentifier = order.getStoreIdentifier();

        dr.save(delivery);

        /** Send Message to RabbitMQ **/
        publisher.publishMessage(new CustomMessage(String.valueOf(order.getOrderId()), delivery.getDeliveryStatus()), order.getStoreIdentifier());
        return delivery;
    }

    public Delivery createDelivery(Delivery delivery){
        Client c = cr.findByPhone(delivery.getClient().getPhone());
        Store s = sr.findByPhone(delivery.getStore().getPhone());
        Delivery d = new Delivery(delivery.getOrderTime(), delivery.getOrderNote());
        if (s == null){
            return null;
        }
        if (c == null){
            cr.save(delivery.getClient());
            d.setClient(delivery.getClient());
        }
        else {
            d.setClient(c);
        }
        d.setStore(s);
        d.setDeliveryStatus("Waiting for rider");
        dr.save(d);
        return d;
    //receive delivery information, process and create delivery, save on repository
    }
    
    public List<Delivery> listDeliveries(){
    //get deliveries from repository, send over to controller
        return dr.findAll();
    }

    public List<Delivery> getDeliveriesWithStatus(String status) {
        return dr.findByDeliveryStatus(status);
    }

    public List<Delivery> getFilteredDeliveries(List<Boolean> delayed, List<String> store, List<String> status) {
        return dr.findByDeliveryDelayedInAndStore_NameInAndDeliveryStatusIn(delayed, store, status);
    }

    public Delivery getDelivery(long id) {
        return dr.findById(id);
    }
    
    public Delivery assignToRider(long deliveryId, String riderPhone){
        //receive information about the delivery and rider, associate the rider with the delivery, save and send back updated delivery to controller
        Delivery d = dr.findById(deliveryId);
        User r = ur.findByPhone(riderPhone);
        if (r == null || !r.getUserType().equals("user") || d.getRider() != null){
            return null;
        }
        d.setRider(r);
        d.setDeliveryStatus("Picking up the order");
        dr.save(d);
        return d;
    }

    public Delivery updateDeliveryStatus(long deliveryId, String status){
        //receive information about the delivery and its status, save and send back updated delivery to controller
        Delivery delivery = dr.findById(deliveryId);

        if (delivery != null){
            delivery.setDeliveryStatus(status);
            dr.save(delivery);
        }

        return delivery;
    }

    public Delivery getDeliveryByRiderAndStatus(String riderPhone, List<String> status) {
        return dr.findByRider_PhoneAndDeliveryStatusIn(riderPhone, status);
    }
}
