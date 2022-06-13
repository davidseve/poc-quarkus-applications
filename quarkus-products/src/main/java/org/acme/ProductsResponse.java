package org.acme;

import java.util.Set;

public class ProductsResponse{
	
	private Set<Product> products; 
	private Metadata metada;
	
	public ProductsResponse() {
		super();
	}
	
	public ProductsResponse(Set<Product> products, Metadata metada) {
		super();
		this.products = products;
		this.metada = metada;
	}
	public ProductsResponse(Set<Product> products, String version, String colour, String mode) {
		super();
		this.products = products;
		metada = new Metadata(version, colour, mode);
	}

	public Metadata getMetada() {
		return metada;
	}

	public void setMetada(Metadata metada) {
		this.metada = metada;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}


	
	
}
