package org.acme;

import java.util.Set;

public class ProductsResponse{
	
	private Set<Product> products; 
	private Metadata metadata;
	
	public ProductsResponse() {
		super();
	}
	
	public ProductsResponse(Set<Product> products, Metadata metadata) {
		super();
		this.products = products;
		this.metadata = metadata;
	}
	public ProductsResponse(Set<Product> products, String version, String colour, String mode) {
		super();
		this.products = products;
		metadata = new Metadata(version, colour, mode);
	}


	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}


	
	
}
