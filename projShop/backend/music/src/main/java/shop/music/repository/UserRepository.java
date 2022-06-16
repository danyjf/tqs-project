package shop.music.repository;

import shop.music.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findById(int id);
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
}
