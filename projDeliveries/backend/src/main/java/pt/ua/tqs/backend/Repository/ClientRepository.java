package pt.ua.tqs.backend.Repository;

import pt.ua.tqs.backend.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByName(String name);
}
