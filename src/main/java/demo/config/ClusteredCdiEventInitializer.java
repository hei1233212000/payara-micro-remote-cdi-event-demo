package demo.config;

import fish.payara.micro.cdi.ClusteredCDIEventBus;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class ClusteredCdiEventInitializer {
    @Inject
    private ClusteredCDIEventBus clusteredCDIEventBus;

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        // it is useless buy it would make this class init during server startup
    }

    @PostConstruct
    public void init() {
        clusteredCDIEventBus.initialize();
    }
}
