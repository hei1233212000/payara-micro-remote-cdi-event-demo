package demo.service;

import demo.model.MyMessage;
import fish.payara.micro.cdi.Inbound;
import fish.payara.micro.cdi.Outbound;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.logging.Logger;

@ApplicationScoped
public class EventService {
    @Inject
    @Outbound
    private Event<MyMessage> event;

    @Inject
    @Outbound(loopBack = true)
    private Event<MyMessage> logbackEvent;

    public void fireEvent(String msg) {
        Logger.getLogger(EventService.class.getName()).info("message to be fired: " + msg);
        event.fire(MyMessage.builder().msg(msg).build());
    }

    public void fireLoopBackEvent(String msg) {
        Logger.getLogger(EventService.class.getName()).info("message(which will be loopBack) to be fired: " + msg);
        logbackEvent.fire(MyMessage.builder().msg(msg).build());
    }

    public void observeEvent(@Observes @Inbound MyMessage myMessage) throws InterruptedException {
        Logger.getLogger(EventService.class.getName()).info("message received: " + myMessage);
    }
}
