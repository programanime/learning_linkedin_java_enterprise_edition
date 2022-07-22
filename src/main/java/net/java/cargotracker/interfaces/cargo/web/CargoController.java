package net.java.cargotracker.interfaces.cargo.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Default;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import net.java.cargotracker.application.util.CargoUtils;
import net.java.cargotracker.domain.model.cargo.Cargo;
import net.java.cargotracker.domain.model.cargo.CargoMessage;
import net.java.cargotracker.domain.model.cargo.CargoRepository;
import net.java.cargotracker.domain.model.cargo.EjbCargoMessage;
import net.java.cargotracker.infrastructure.messaging.jms.JmsSenderSample;

@Named
@ViewScoped
public class CargoController implements Serializable {

    private static final long serialVersionUID = 1L;
    private String msg;
    private List<Cargo> listCargo;
    private List<CargoMessage> messages;

    public List<CargoMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<CargoMessage> messages) {
        this.messages = messages;
    }

    @Inject
    private CargoUtils cargoUtils;

    @Inject
    private CargoRepository cargoRepository;

    @Inject
    private EjbCargoMessage ejbCargoMessage;

    @Inject
    private JmsSenderSample jmsSenderSample;

    public String getTitle(){
        return cargoUtils.getTitle();
    }
    
    @PostConstruct
    public void loadCargos() {
        this.listCargo = cargoRepository.findAll();
        this.messages = ejbCargoMessage.findAll();
    }

    public List<Cargo> getListCargo() {
        return listCargo;
    }

    public void setListCargo(List<Cargo> listCargo) {
        this.listCargo = listCargo;
    }

    public void sendMessageToQueue() {
        this.jmsSenderSample.send(msg);
    }

    public void loadMessagesFromQueue(){
        this.messages = ejbCargoMessage.findAll();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
