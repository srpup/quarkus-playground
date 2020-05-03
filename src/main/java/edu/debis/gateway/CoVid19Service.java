package edu.debis.gateway;

import edu.debis.dto.external.covid.CovidData;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@RegisterRestClient(configKey = "ext.api.covid19")
public interface CoVid19Service {

    @GET
    @Path("summary")
    @Produces(MediaType.APPLICATION_JSON)
    CovidData getSummary();
}
