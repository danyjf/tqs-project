package pt.ua.tqs.backend.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pt.ua.tqs.backend.Config.CustomMessage;
import pt.ua.tqs.backend.Config.MessagePublisher;
import pt.ua.tqs.backend.Repository.*;
import pt.ua.tqs.backend.Service.DeliveryService;
import pt.ua.tqs.backend.Model.*;

import java.sql.Timestamp;
import java.time.Instant;

@ExtendWith(MockitoExtension.class)
class DeliveryServiceTests {
    @Mock
    private DeliveryRepository deliveryRepository;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private StoreRepository storeRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private MessagePublisher publisher;

    @InjectMocks
    private DeliveryService deliveryService;

    @Test
    void CreateDeliveryWithExistingUser(){
        Client client = new Client();
        Store store = new Store();
        when(clientRepository.findByPhone("911234567")).thenReturn(client);
        when(storeRepository.findByPhone("256245365")).thenReturn(store);
        Delivery result = deliveryService.createDelivery(
                new Delivery(
                        Timestamp.from(Instant.now()),
                        new Store("256245365"),
                        new Client("Tiago", "123 Avenue", "911234567"),
                        "Fragile objects"
                )
        );
        //result is a delivery with the right client and store
        assertEquals(client, result.getClient());
        assertEquals(store, result.getStore());

    }

    @Test
    void CreateDeliveryWithNonExistingUser(){
        Store store = new Store();
        when(clientRepository.findByPhone("911234568")).thenReturn(null);
        when(storeRepository.findByPhone("256245365")).thenReturn(store);
        Delivery result = deliveryService.createDelivery(
                new Delivery(
                        Timestamp.from(Instant.now()),
                        new Store("256245365"),
                        new Client("Tiago", "123 Avenue", "911234568"),
                        "Fragile objects"
                )
        );
        //result should be a client with the information sent
        assertEquals("911234568", result.getClient().getPhone());
    }

    @Test
    void CreateDeliveryWithNonExistingStore(){
        Client client = new Client();
        when(clientRepository.findByPhone("911234567")).thenReturn(client);
        when(storeRepository.findByPhone("256245365")).thenReturn(null);
        Delivery result = deliveryService.createDelivery(
                new Delivery(
                        Timestamp.from(Instant.now()),
                        new Store("256245365"),
                        new Client("Tiago", "123 Avenue", "911234567"),
                        "Fragile objects"
                )
        );
        //result should be a null since store doesnt exist
        assertEquals(null, result);
    }

    @Test
    void AssignRiderToDelivery(){
        User rider = new User();
        rider.setUserType("user");
        Delivery delivery = new Delivery();
        when(deliveryRepository.findById(1)).thenReturn(delivery);
        when(userRepository.findByPhone("123456789")).thenReturn(rider);
        Delivery result = deliveryService.assignToRider(1, "123456789");
        //result should be the delivery with the rider properly set
        assertEquals(rider, result.getRider());
    }

    @Test
    void AssignNonRiderToDelivery(){
        User rider = new User();
        rider.setUserType("manager");
        Delivery delivery = new Delivery();
        when(deliveryRepository.findById(1)).thenReturn(delivery);
        when(userRepository.findByPhone("123456789")).thenReturn(rider);
        Delivery result = deliveryService.assignToRider(1, "123456789");
        //result should be a null since User isnt a rider
        assertEquals(null, result);
    } 

    @Test
    void AssignRiderToAlreadyAssignedDelivery(){
        User rider = new User();
        Delivery delivery = new Delivery();
        rider.setUserType("Rider");
        delivery.setRider(rider);
        when(deliveryRepository.findById(1)).thenReturn(delivery);
        when(userRepository.findByPhone("123456789")).thenReturn(rider);
        Delivery result = deliveryService.assignToRider(1, "123456789");
        //result should be a null since rider is already assigned
        assertEquals(null, result);

    }

    @Test
    void UpdateDeliveryStatus(){
        Delivery delivery = new Delivery();
        delivery.setDeliveryStatus("Available for a rider");
        when(deliveryRepository.findById(1)).thenReturn(delivery);
        when(publisher.publishMessage(Mockito.any(), Mockito.any())).thenReturn(null);
        Delivery updatedDelivery = deliveryService.updateDeliveryStatus(1, "Assigned to a rider");
        String status = updatedDelivery.getDeliveryStatus();

        assertEquals("Assigned to a rider", status);
    }
}
