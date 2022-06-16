package shop.music.repository;

import shop.music.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository  extends JpaRepository<Manager, Integer>{
    Manager findById(int id);
    Manager findByEmail(String email);
    Manager findByEmailAndPassword(String email, String password);
}
