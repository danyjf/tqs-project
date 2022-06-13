package pt.ua.tqs.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ua.tqs.backend.Repository.StoreRepository;

@Service
public class StoreService {
    @Autowired
    private StoreRepository sr;
}
