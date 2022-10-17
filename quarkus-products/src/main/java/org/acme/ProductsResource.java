package org.acme;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.config.inject.ConfigProperty;
//import org.eclipse.microprofile.metrics.MetricUnits;
//import org.eclipse.microprofile.metrics.annotation.Counted;
//import org.eclipse.microprofile.metrics.annotation.SimplyTimed;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/products")
public class ProductsResource {
	
	@ConfigProperty(name = "application.version", defaultValue="none") 
	String version;
	
	@ConfigProperty(name = "application.colour", defaultValue="none") 
	String colour;
	
	@ConfigProperty(name = "application.mode", defaultValue="none") 
	String mode;

    @Inject
    @RestClient
    DiscountsService discountsService;

    @GET
    //@Counted(name = "get_products:counted", description = "count of get products")
    //@SimplyTimed(name = "get_products:process_time",
    //       description = "A measure of how long it takes to process products",
    //       unit = MetricUnits.MILLISECONDS)
    public ProductsResponse products() {
    	final Product product = new Product();
        final Set<Product> products = new LinkedHashSet<>();
     
        product.setName("TV 4K");
        product.setPrice("1500€");
        product.setDiscountInfo(discountsService.getAll());
        products.add(product);
        
        final ProductsResponse productsResponse = new ProductsResponse(products, version, colour, mode);
        productsResponse.setProducts(products);
        return productsResponse;
    }
}
