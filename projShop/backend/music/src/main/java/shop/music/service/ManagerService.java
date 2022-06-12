package shop.music.service;

import shop.music.model.Manager;
import shop.music.repository.ManagerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository repository;

    public Manager saveManager(Manager manager) {
        return repository.save(manager);
    }

    public List<Manager> saveManagers(List<Manager> managers) {
        return repository.saveAll(managers);
    }

    public Page<Manager> getManagers(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Manager> getManagers() {
        return repository.findAll();
    }

    public Manager getManagerById(int id) {
        return repository.findById((int) id);
    }

    public boolean isEmailInUse(String email) {
        return repository.findByEmail(email) != null;
    }

    public Manager getManagerLogin(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    public String deleteManager(int id) {
        repository.deleteById(id);
        return "manager (id=" + id + ") removed!";
    }
    
}
