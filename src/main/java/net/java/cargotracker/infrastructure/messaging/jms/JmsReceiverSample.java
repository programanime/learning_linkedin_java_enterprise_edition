package net.java.cargotracker.infrastructure.messaging.jms;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import net.java.cargotracker.domain.model.cargo.CargoMessageRepository;
import net.java.cargotracker.domain.model.cargo.EjbCargoMessage;

 @MessageDriven(
     activationConfig = {
     @ActivationConfigProperty(propertyName = "destinationType",
             propertyValue = "javax.jms.Queue"),
     @ActivationConfigProperty(propertyName = "destinationLookup",
             propertyValue = "java:app/jms/SampleQueue")
})
public class JmsReceiverSample implements MessageListener {

    private static final Logger logger = Logger.getLogger(
            JmsReceiverSample.class.getName());

    @Inject
    EjbCargoMessage ejbCargoMessage;

    @Override
    public void onMessage(Message message) {
        try {
            String msg = message.getBody(String.class);
            ejbCargoMessage.save(msg);
            logger.log(Level.INFO,
                    "new sample message {0} ",
                    msg);
        } catch (JMSException ex) {
            logger.log(Level.WARNING, "Error processing message.", ex);
        }
    }
}
