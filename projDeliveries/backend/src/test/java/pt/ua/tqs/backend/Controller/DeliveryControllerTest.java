package pt.ua.tqs.backend.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import pt.ua.tqs.backend.Model.*;
import pt.ua.tqs.backend.Repository.*;
import org.springframework.http.RequestEntity;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@TestPropertySource(properties = "spring.jpa.hibernate.ddl-auto=update")
public class DeliveryControllerTest {
    @Container
    public static final MySQLContainer mysql = new MySQLContainer("mysql:5.7")
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
        registry.add("spring.jpa.database-platform", () -> "org.hibernate.dialect.MySQL5InnoDBDialect");
    }

    @Test
    void createDelivery() {
        Client client = new Client("Tiago", "123 Avenue", "911234568");
        Store store = new Store("Rockin", "Wrong Way Street", "123456780");
        clientRepository.saveAndFlush(client);
        storeRepository.saveAndFlush(store);

//        MultiValueMap<String, String> hm = new LinkedMultiValueMap<String, String>();
//        hm.add("clientName", "Tiago");
//        hm.add("clientAddress", "123 Avenue");
//        hm.add("clientPhone", "911234568");
//        hm.add("storePhone", "123456780");
//        hm.add("orderTime","2000-02-23 11:33:23");
//        hm.add("orderNote","fragile");

//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(hm, headers);

//        Delivery request = new Delivery(new Timestamp(System.currentTimeMillis()), new Store("123456780"), new Client("Tiago", "123 Avenue", "911234568"), "fragile");
        Delivery request = new Delivery(Timestamp.valueOf("2000-02-23 11:33:23"), new Store("123456780"), new Client("Tiago", "123 Avenue", "911234568"), "fragile");

        ResponseEntity<Delivery> response = restTemplate.postForEntity("/delivery", request ,Delivery.class );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).extracting(Delivery::getClient).extracting(Client::getPhone).isEqualTo(client.getPhone());
        assertThat(response.getBody()).extracting(Delivery::getStore).extracting(Store::getPhone).isEqualTo(store.getPhone());
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
        
        Client client = new Client("Tiago", "123 Avenue", "911234567");
        Store store = new Store("Rockin", "Wrong Way Street", "123456789");
        clientRepository.saveAndFlush(client);
        storeRepository.saveAndFlush(store);

        Delivery del = new Delivery(Timestamp.from(Instant.now()), "fragile");
        del.setClient(client);
        del.setStore(store);
        deliveryRepository.saveAndFlush(del);
        User u = new User("Tempo","asd@ua.pt","1234","123456789","Rider");
        userRepository.saveAndFlush(u);

        MultiValueMap<String, String> hm = new LinkedMultiValueMap<String, String>();
        hm.add("deliveryId", String.valueOf(del.getId()));
        hm.add("riderPhone", "123456789");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(hm, headers);

        ResponseEntity<Delivery> response = restTemplate.postForEntity("/delivery/rider", request , Delivery.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).extracting(Delivery::getClient).extracting(Client::getPhone).isEqualTo(client.getPhone());
        assertThat(response.getBody()).extracting(Delivery::getStore).extracting(Store::getPhone).isEqualTo(store.getPhone());
        assertThat(response.getBody()).extracting(Delivery::getRider).extracting(User::getPhone).isEqualTo(u.getPhone());
        
    }

    @Test
    void UpdateDelivery() {
        Delivery del = new Delivery();
        deliveryRepository.saveAndFlush(del);

        String status = "delivered";

        HashMap<String, Object> hm = new HashMap<String, Object>();
        hm.put("deliveryId", 1);
        hm.put("status", status);

        ResponseEntity<Delivery> response = restTemplate.postForEntity("/delivery/status", hm, Delivery.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).extracting(Delivery::getDeliveryStatus).isEqualTo(status);
    }
}
