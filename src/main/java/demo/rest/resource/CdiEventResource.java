package demo.rest.resource;

import demo.service.EventService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.logging.Logger;

@Path("")
public class CdiEventResource {
    private EventService eventService;

    @Inject
    public CdiEventResource(EventService eventService) {
        this.eventService = eventService;
    }

    @GET
    public String fireClusteredEvent(@QueryParam("msg") String msg) {
        Logger.getLogger(CdiEventResource.class.getName()).info("message: " + msg);
        eventService.fireEvent(msg);
        return "DONE";
    }

    @Path("loop-back")
    @GET
    public String fireClusteredLoogBackEvent(@QueryParam("msg") String msg) {
        Logger.getLogger(CdiEventResource.class.getName()).info("message: " + msg);
        eventService.fireLoopBackEvent(msg);
        return "DONE";
    }
}
