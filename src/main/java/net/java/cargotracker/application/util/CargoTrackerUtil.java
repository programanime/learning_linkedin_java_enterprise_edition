package net.java.cargotracker.application.util;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
// @TransactionAttribute(TransactionAttributeType.NEVER)
public class CargoTrackerUtil {
    @PersistenceContext
    private EntityManager entityManager;

    // @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void removeCargoTracker() {
        entityManager.createQuery("DELETE FROM HandlingEvent").executeUpdate();
        entityManager.createQuery("DELETE FROM Leg").executeUpdate();
        entityManager.createQuery("DELETE FROM Cargo").executeUpdate();
        entityManager.createQuery("DELETE FROM CarrierMovement").executeUpdate();
        entityManager.createQuery("DELETE FROM Voyage").executeUpdate();
        entityManager.createQuery("DELETE FROM Location").executeUpdate();
    }
}
