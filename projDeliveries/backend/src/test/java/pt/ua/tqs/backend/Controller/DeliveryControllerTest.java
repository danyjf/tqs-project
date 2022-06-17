package pt.ua.tqs.backend.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import pt.ua.tqs.backend.Model.*;
import pt.ua.tqs.backend.Repository.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@TestPropertySource(properties = "spring.jpa.hibernate.ddl-auto=create")
public class DeliveryControllerTest {
    @Container
    public static final MySQLContainer mysql = new MySQLContainer("mysql:8.0")
            .withDatabaseName("test")
            .withUsername("tqs_p4_g4")
            .withPassword("tqs_p4_g4_password");

    @LocalServerPort
    int localPortForTestServer;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StoreRepository storeRepository;

    @DynamicPropertySource
    public static void setDatasourceProperties(final DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.password", mysql::getPassword);
        registry.add("spring.datasource.username", mysql::getUsername);
    }

    @Test
    void createDelivery() {
        Client client = new Client();
        Store store = new Store();
        clientRepository.saveAndFlush(client);
        storeRepository.saveAndFlush(store);

        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("clientName", "Tiago");
        hm.put("clientAddress", "123 Avenue");
        hm.put("clientPhone", "911234567");
        hm.put("storePhone", "123456789");
        hm.put("orderTime","2000-02-23 12:33:23, 111111111");
        hm.put("orderNote","fragile");

        ResponseEntity<Delivery> response = restTemplate.postForEntity("/delivery", hm ,Delivery.class );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).extracting(Delivery::getClient).isEqualTo(client);
        assertThat(response.getBody()).extracting(Delivery::getStore).isEqualTo(store);
    }

    @Test
    void ListDeliveries() {
        Delivery del = new Delivery(Timestamp.from(Instant.now()), "fragile");
        deliveryRepository.saveAndFlush(del);

        ResponseEntity<List<Delivery>> response = restTemplate.exchange("/deliveries", HttpMethod.GET,null,  new ParameterizedTypeReference<List<Delivery>>() {} );
        
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).extracting(List::size).isEqualTo(1);
    }

    @Test
    void AssignDelivery() {
        
        Client client = new Client();
        Store store = new Store();
        clientRepository.saveAndFlush(client);
        storeRepository.saveAndFlush(store);

        Delivery del = new Delivery(Timestamp.from(Instant.now()), "fragile");
        del.setClient(client);
        del.setStore(store);
        deliveryRepository.saveAndFlush(del);
        User u = new User();
        u.setUserType("Rider");
        u.setPhone("123456789");
        userRepository.saveAndFlush(u);

        HashMap<String, Object> hm = new HashMap<String, Object>();
        hm.put("deliveryId", 1);
        hm.put("riderPhone", "123456789");

        ResponseEntity<Delivery> response = restTemplate.postForEntity("/delivery/rider",hm , Delivery.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).extracting(Delivery::getClient).isEqualTo(client);
        assertThat(response.getBody()).extracting(Delivery::getStore).isEqualTo(store);
        assertThat(response.getBody()).extracting(Delivery::getRider).isEqualTo(u);
        
    }
}
