package pt.ua.tqs.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ua.tqs.backend.Repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository cr;
    
}
