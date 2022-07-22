package net.java.cargotracker.infrastructure.messaging.jms;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;

@ApplicationScoped
public class JmsSenderSample  implements Serializable {
    private static final int LOW_PRIORITY = 0;
    @Inject
    JMSContext jmsContext;
    @Resource(lookup = "java:app/jms/SampleQueue")
    private Destination cargoHandledQueue;

    public void send(String msg) {
        jmsContext.createProducer()
                .setPriority(LOW_PRIORITY)
                .setDisableMessageID(true)
                .setDisableMessageTimestamp(true)
                .send(cargoHandledQueue,msg);
    }
}
