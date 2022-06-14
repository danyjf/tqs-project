package pt.ua.tqs.backend.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pt.ua.tqs.backend.Repository.DeliveryRepository;
import pt.ua.tqs.backend.Service.DeliveryService;

@ExtendWith(MockitoExtension.class)
public class DeliveryServiceTests {
    @Mock
    private DeliveryRepository deliveryRepository;

    @InjectMocks
    private DeliveryService deliveryService;

    @Test
    void CreateDeliveryWithExistingUser(){

    }

    @Test
    void CreateDeliveryWithNonExistingUser(){

    }

    @Test
    void CreateDeliveryWithNonExistingStore(){

    }

    @Test
    void AssignRiderToDelivery(){

    }

    @Test
    void AssignNonRiderToDelivery(){

    } 

    @Test
    void AssignRiderToAlreadyAssignedDelivery(){

    }
}