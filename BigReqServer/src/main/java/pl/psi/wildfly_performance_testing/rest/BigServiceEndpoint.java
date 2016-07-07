package pl.psi.wildfly_performance_testing.rest;

import pl.psi.wildfly_performance_testing.service.BigService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by ftrela on 2016-07-05.
 */
@Path("/big-service")
public class BigServiceEndpoint {
    @Inject
    BigService bigService;

    @GET
    @Path("/calculate1")
    @Produces({"application/json"})
    @Transactional
    public Response calculate1() {
        bigService.calculate1();
        return Response.ok().build();
    }
}
