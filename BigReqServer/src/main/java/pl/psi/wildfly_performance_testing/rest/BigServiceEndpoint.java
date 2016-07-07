package pl.psi.wildfly_performance_testing.rest;

import pl.psi.wildfly_performance_testing.service.BigService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by ftrela on 2016-07-05.
 */
@Path("/big-service")
public class BigServiceEndpoint {
    @Inject
    private BigService bigService;

    @GET
    @Path("/calculate1/{howManyRandomEntities}")
    @Produces({"application/json"})
    @Transactional
    public Response calculate1(@PathParam("howManyRandomEntities") int howManyRandomEntities) {
        bigService.calculate1(howManyRandomEntities);
        return Response.ok().build();
    }

    @GET
    @Path("/calculate2")
    @Produces({"application/json"})
    @Transactional
    public Response calculate2() {
        double result = bigService.calculate2();
        return Response.ok(result).build();
    }
}
