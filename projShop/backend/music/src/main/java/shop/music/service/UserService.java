package shop.music.service;

import shop.music.model.User;
import shop.music.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public List<User> saveUsers(List<User> users) {
        return repository.saveAll(users);
    }

    public Page<User> getUsers(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUserById(int id) {
        return repository.findById((int) id);
    }

    public boolean isEmailInUse(String email) {
        return repository.findByEmail(email) != null;
    }

    public User getUserLogin(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    public String deleteUser(int id) {
        repository.deleteById(id);
        return "user (id=" + id + ") removed!";
    }

}