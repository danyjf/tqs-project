package pt.ua.tqs.backend.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import pt.ua.tqs.backend.Model.Delivery;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.sql.Timestamp;
import java.time.Instant;

@DataJpaTest
@TestPropertySource(locations = "classpath:pt/ua/tqs/backend/repositorytest.properties")
public class DeliveryRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Test
    void findDeliveryById() {
        Delivery del = new Delivery(Timestamp.from(Instant.now()), "Fragile");
        testEntityManager.persistAndFlush(del);

        Delivery fromDb = deliveryRepository.findById(del.getId());

        assertThat(fromDb).isNotNull();
        assertThat(fromDb.getOrderNote()).isEqualTo(del.getOrderNote());
        assertThat(fromDb.getOrderTime()).isEqualTo(del.getOrderTime());
    }

}
