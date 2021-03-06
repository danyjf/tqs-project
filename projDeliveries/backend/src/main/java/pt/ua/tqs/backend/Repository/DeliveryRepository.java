package pt.ua.tqs.backend.Repository;

import pt.ua.tqs.backend.Model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    Delivery findById(long id);
    List<Delivery> findByDeliveryStatus(String status);
    List<Delivery> findByDeliveryDelayedInAndStore_NameInAndDeliveryStatusIn(List<Boolean> delayed, List<String> store, List<String> status);
    Delivery findByRider_PhoneAndDeliveryStatusIn(String phone, List<String> status);
    Delivery findByRider_Phone(String phone);
}
