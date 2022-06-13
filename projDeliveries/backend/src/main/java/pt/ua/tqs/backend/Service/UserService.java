package pt.ua.tqs.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ua.tqs.backend.Model.User;
import pt.ua.tqs.backend.Repository.UserRepository;

import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository ur;

    public User getUserByEmailAndPassword(String email, String password) {
        return null;
    }

    public Map<String, String> createUser(User user) {
        return null;
    }
}
