package net.java.cargotracker.domain.model.cargo;

import java.util.List;

public interface CargoMessageRepository {
    List<CargoMessage> findAll();
    void save(String msg);
}
