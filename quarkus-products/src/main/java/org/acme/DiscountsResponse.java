package org.acme;

import java.util.Set;

public class DiscountsResponse{
	
	private Set<Discount> discounts; 
	private Metadata metada;
	
	public DiscountsResponse() {
		super();
	}
	
	public DiscountsResponse(Set<Discount> discounts, Metadata metada) {
		super();
		this.discounts = discounts;
		this.metada = metada;
	}
	public DiscountsResponse(Set<Discount> discounts, String version, String colour, String mode) {
		super();
		this.discounts = discounts;
		metada = new Metadata(version, colour, mode);
	}

	public Metadata getMetada() {
		return metada;
	}

	public void setMetada(Metadata metada) {
		this.metada = metada;
	}

	public Set<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(Set<Discount> discounts) {
		this.discounts = discounts;
	}
	
	
}
