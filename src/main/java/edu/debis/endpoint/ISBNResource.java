package edu.debis.endpoint;

import edu.debis.application.ISBNService;
import edu.debis.application.impl.ISBNServiceJDBC;
import edu.debis.dto.ISBN;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/isbn")
public class ISBNResource {

    @Inject
    private ISBNService isbnService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<ISBN> getlAll() {

        return isbnService.getAll();
    }

    @GET
    @Path("/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("code") String code) {

        ISBN isbn =  isbnService.getDetails(code);
        return Response.ok(isbn).build();
    }
}
