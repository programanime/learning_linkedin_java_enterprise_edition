package net.java.cargotracker.application.util;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;

@ApplicationScoped
public class CargoUtils implements Serializable {
    private static final long serialVersionUID = 1L;

    public String getTitle(){
        return "title is this";
    }
}
