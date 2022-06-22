package pt.ua.tqs.backend.Controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import pt.ua.tqs.backend.Model.User;
import pt.ua.tqs.backend.Repository.UserRepository;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@TestPropertySource(properties = "spring.jpa.hibernate.ddl-auto=create")
public class UserControllerTest {
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
    private UserRepository userRepository;

    @DynamicPropertySource
    public static void setDatasourceProperties(final DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.password", mysql::getPassword);
        registry.add("spring.datasource.username", mysql::getUsername);
    }

    @Test
    void whenGetUserByExistingEmailAndPassword_thenUserShouldBeReturned() {
        User user = new User("daniel", "daniel@gmail.com", "danielpass", "987737849", "user");
        userRepository.saveAndFlush(user);

        ResponseEntity<User> response = restTemplate.getForEntity(String.format("/users/%s/%s", user.getEmail(), user.getPassword()), User.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).extracting(User::getEmail).isEqualTo(user.getEmail());
        assertThat(response.getBody()).extracting(User::getPassword).isEqualTo(user.getPassword());
    }

    @Test
    void whenGetUserByWrongPassword_thenNullShouldBeReturned() {
        User user = new User("joao", "joao@gmail.com", "joaopass", "984738929", "user");
        userRepository.saveAndFlush(user);

        ResponseEntity<User> response = restTemplate.getForEntity(String.format("/users/%s/%s", user.getEmail(), "WrongPassword"), User.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNull();
    }

    @Test
    void whenCreateUserWithValidInput_thenSuccessMessageShouldBeReturned() {
        User user = new User("francisco", "francisco@gmail.com", "franciscopass", "983948394", "user");

        ResponseEntity<Map<String, String>> response = restTemplate.exchange(
                "/users",
                HttpMethod.POST,
                new HttpEntity<>(user),
                new ParameterizedTypeReference<Map<String, String>>() {}
        );

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody().get("status")).isEqualTo("success");
    }
}
