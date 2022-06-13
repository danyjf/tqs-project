package pt.ua.tqs.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ua.tqs.backend.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository ur;
}
