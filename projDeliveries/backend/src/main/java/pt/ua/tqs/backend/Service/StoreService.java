package pt.ua.tqs.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ua.tqs.backend.Model.Store;
import pt.ua.tqs.backend.Repository.StoreRepository;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    public List<Store> getStores() {
        return storeRepository.findAll();
    }
}
