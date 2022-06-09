package shop.music.service;

import shop.music.model.Manager;
import shop.music.repository.ManagerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository repository;
    
}
