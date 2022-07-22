package net.java.cargotracker.interfaces.tracking.web;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import net.java.cargotracker.domain.model.cargo.Cargo;
import net.java.cargotracker.domain.model.cargo.CargoRepository;
import net.java.cargotracker.domain.model.cargo.TrackingId;
import net.java.cargotracker.domain.model.handling.HandlingEvent;
import net.java.cargotracker.domain.model.handling.HandlingEventRepository;

@Named
@ViewScoped
public class Track implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CargoRepository cargoRepository;
    
    @Inject
    private HandlingEventRepository handlingEventRepository;

    private String trackingId;
    private CargoTrackingViewAdapter cargo;

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        // TODO See if a more global trimming mechanism is needed.
        if (trackingId != null) {
            trackingId = trackingId.trim();
        }

        this.trackingId = trackingId;
    }

    public CargoTrackingViewAdapter getCargo() {
        return cargo;
    }

    public void setCargo(CargoTrackingViewAdapter cargo) {
        this.cargo = cargo;
    }

    /**
     * @param query The query parameter is required by PrimeFaces but we don't 
     * use it.
     */
    public List<TrackingId> getTrackingIds(String query) {
        return cargoRepository.getAllTrackingIds();
    }

    public void onTrackById() {
        Cargo cargo = cargoRepository.find(new TrackingId(trackingId));

        if (cargo != null) {
            List<HandlingEvent> handlingEvents = handlingEventRepository
                    .lookupHandlingHistoryOfCargo(new TrackingId(trackingId))
                    .getDistinctEventsByCompletionTime();
            this.cargo = new CargoTrackingViewAdapter(cargo, handlingEvents);
        } else {
            // TODO See if this can be injected.
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage message = new FacesMessage(
                    "Cargo with tracking ID: " + trackingId + " not found.");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, message);
            this.cargo = null;
        }
    }
}
