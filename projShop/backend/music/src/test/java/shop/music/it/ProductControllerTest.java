package shop.music.it;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import shop.music.model.Product;
import shop.music.repository.ProductRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@TestPropertySource(properties = "spring.jpa.hibernate.ddl-auto=create")
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Container
    public static final MySQLContainer mysql = new MySQLContainer("mysql:8.0")
            .withDatabaseName("test")
            .withUsername("tqs_p4_g4")
            .withPassword("tqs_p4_g4_password");

    @LocalServerPort
    int localPortForTestServer;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ProductRepository productRepository;

    @DynamicPropertySource
    public static void setDatasourceProperties(final DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.password", mysql::getPassword);
        registry.add("spring.datasource.username", mysql::getUsername);
    }

    @Test
    public void whenGetAllProducts_thenStatus200() throws Exception {
        mvc.perform(get("/api/v1/products").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void whenGetProductsById_thenStatus200AndReturnProductJSON() throws Exception {
        Product product = new Product();
        productRepository.saveAndFlush(product);

        mvc.perform(get("/api/v1/product/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void whenPostProductOrders_thenStatus200() throws Exception {
        mvc.perform( MockMvcRequestBuilders
                        .post("/api/v1/products")
                        .content("[{\"imageURL\": \"https://musicfactory.pt/MEDIA/32/IMAGE/PRODUCTS/YA/YA%20C40II.jpg\",  \"name\": \"Acoustic Guitar\",  \"description\": \"An acoustic guitar is a musical instrument in the string family.\",  \"category\": \"Musical Instrument\", \"price\": \"80\",  \"stock\": \"12\"}]")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").exists());
    }
}
