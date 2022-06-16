package shop.music.it;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest()
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void whenGetAllProducts_thenStatus200() throws Exception {
        mvc.perform(get("/api/v1/products").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void whenGetProductsById_thenStatus200AndReturnProductJSON() throws Exception {
        mvc.perform(get("/api/v1/product/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void whenPostProductOrders_thenStatus200() throws Exception {
        mvc.perform( MockMvcRequestBuilders
                        .post("/api/v1/products")
                        .content("{\"imageURL\": \"https://musicfactory.pt/MEDIA/32/IMAGE/PRODUCTS/YA/YA%20C40II.jpg\",  \"name\": \"Acoustic Guitar\",  \"description\": \"An acoustic guitar is a musical instrument in the string family.\",  \"category\": \"Musical Instrument\", \"price\": \"80\",  \"stock\": \"12\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists());
    }
}
