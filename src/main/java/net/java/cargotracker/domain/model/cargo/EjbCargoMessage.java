package net.java.cargotracker.domain.model.cargo;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EjbCargoMessage implements Serializable {

    @Inject
    private CargoMessageRepository cargoMessageRepository;
    
    public List<CargoMessage> findAll() {
        return cargoMessageRepository.findAll();
    }

    public void save(String msg){
        cargoMessageRepository.save(msg);
    }
}