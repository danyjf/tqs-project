package pt.ua.tqs.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ua.tqs.backend.Model.User;
import pt.ua.tqs.backend.Repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public Map<String, String> createUser(User user) {
        Map<String, String> response = new HashMap<String, String>();

        if(userRepository.findByUsername(user.getUsername()) != null) {
            response.put("status", "fail");
            response.put("message", "Username already in use");
            return response;
        } else if(userRepository.findByEmail(user.getEmail()) != null) {
            response.put("status", "fail");
            response.put("message", "Email already in use");
            return response;
        } else if(userRepository.findByPassword(user.getPassword()) != null) {
            response.put("status", "fail");
            response.put("message", "Password already in use");
            return response;
        } else if(userRepository.findByPhone(user.getPhone()) != null) {
            response.put("status", "fail");
            response.put("message", "Phone already in use");
            return response;
        }

        userRepository.save(user);
        response.put("status", "success");
        response.put("message", "Successfully registered");
        return response;
    }
}
