package pt.ua.tqs.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ua.tqs.backend.Repository.DeliveryRepository;
import pt.ua.tqs.backend.Model.Delivery;
import pt.ua.tqs.backend.Model.User;

import java.util.List;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository dr;
    
    public Delivery create_delivery(){
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
