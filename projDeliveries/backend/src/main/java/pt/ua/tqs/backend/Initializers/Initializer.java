package pt.ua.tqs.backend.Initializer;

import pt.ua.tqs.backend.Model.*;
import pt.ua.tqs.backend.Repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class Initializer implements CommandLineRunner{

    private final UserRepository ur;
    
    public Initializer(UserRepository ur){
        this.ur = ur;
    
    }
    
    @Override
    public void run(String... strings){
        //initialize things here
    }

    }

}
