package edu.debis.endpoint;

import edu.debis.gateway.CoVid19Service;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/covid")
public class CoVidResource {

    @Inject
    @RestClient
    CoVid19Service coVid19Service;

    @GET
    @Path("/summary")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getlAll() {

        return Response.ok(coVid19Service.getSummary()).build();
    }
}
