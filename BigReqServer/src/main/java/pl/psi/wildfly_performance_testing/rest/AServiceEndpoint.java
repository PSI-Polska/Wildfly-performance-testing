package pl.psi.wildfly_performance_testing.rest;

import pl.psi.wildfly_performance_testing.model.big.A;
import pl.psi.wildfly_performance_testing.service.AService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by ftrela on 2016-07-06.
 */
@Path("/a-service")
public class AServiceEndpoint {
    @Inject
    private AService aService;

    @GET
    @Path("/as")
    @Produces({"application/json"})
    @Transactional
    public Response getAList() {
        List<A> aList = aService.getAList();
        return Response.ok(aList).build();
    }

    @POST
    @Path("as/create")
    @Consumes({"application/json"})
    @Transactional
    public Response createA(A a) {
        aService.createA(a);
        return Response.ok().build();
    }
}
