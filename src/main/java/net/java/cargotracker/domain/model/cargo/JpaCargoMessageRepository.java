package net.java.cargotracker.domain.model.cargo;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class JpaCargoMessageRepository implements CargoMessageRepository, Serializable {

    private static final long serialVersionUID = 1L;
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CargoMessage> findAll() {
        return entityManager.createNamedQuery("CargoMessage.findAll", CargoMessage.class)
                .getResultList();
    }

    @Override
    public void save(String msg) {
        entityManager.persist(new CargoMessage(msg));
    }
}
