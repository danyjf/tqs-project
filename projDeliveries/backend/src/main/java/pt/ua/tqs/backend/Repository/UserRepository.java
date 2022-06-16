package pt.ua.tqs.backend.Repository;

import pt.ua.tqs.backend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAndPassword(String email, String password);
    User findByUsername(String username);
    User findByEmail(String email);
    User findByPassword(String password);
    User findByPhone(String phone);
}
