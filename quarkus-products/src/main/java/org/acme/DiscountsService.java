package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/discounts")
@RegisterRestClient(configKey="discounts-api")
public interface DiscountsService {
    
    @GET
    DiscountsResponse getAll();
}
