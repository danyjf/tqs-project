package pt.ua.tqs.backend.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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

    private DeliveryService deliveryService;

    @BeforeEach
    void StartUp(){
        deliveryService = new DeliveryService(deliveryRepository,clientRepository,storeRepository, userRepository);
    }
    @Test
    void CreateDeliveryWithExistingUser(){
        Client client = new Client();
        Store store = new Store();
        when(clientRepository.findByPhone("911234567")).thenReturn(client);
        when(storeRepository.findByPhone("256245365")).thenReturn(store);
        Delivery result = deliveryService.createDelivery("911234567","256245365",Timestamp.from(Instant.now()),"Fragile objects");
        //fails here since result is a null for now
        assertEquals(client, result.getClient());
        assertEquals(store, result.getStore());

    }

    @Test
    void CreateDeliveryWithNonExistingUser(){
        Store store = new Store();
        when(clientRepository.findByPhone("911234567")).thenReturn(null);
        when(storeRepository.findByPhone("256245365")).thenReturn(store);
        Delivery result = deliveryService.createDelivery("911234567","256245365",Timestamp.from(Instant.now()),"Fragile objects");
        //result should be a null, since client doesnt exist
        assertEquals(null, result);
    }

    @Test
    void CreateDeliveryWithNonExistingStore(){
        Client client = new Client();
        when(clientRepository.findByPhone("911234567")).thenReturn(client);
        when(storeRepository.findByPhone("256245365")).thenReturn(null);
        Delivery result = deliveryService.createDelivery("911234567","256245365",Timestamp.from(Instant.now()),"Fragile objects");
        //result should be a null since store doesnt exist
        assertEquals(null, result);
    }

    @Test
    void AssignRiderToDelivery(){
        User rider = new User();
        rider.setUserType("Rider");
        Delivery delivery = new Delivery();
        when(deliveryRepository.findById(1)).thenReturn(delivery);
        when(userRepository.findByPhone("123456789")).thenReturn(rider);
        Delivery result = deliveryService.assignToRider(1, "123456789");
        //result should be a null since store doesnt exist
        delivery.setRider(rider);
        assertEquals(delivery, result);

    }

    @Test
    void AssignNonRiderToDelivery(){
        User rider = new User();
        rider.setUserType("Manager");
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
}