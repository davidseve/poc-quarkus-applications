package org.acme;

import java.util.Objects;

public class Product {
    
    private DiscountsResponse discountInfo;
    private String name;
    private String price;
    private String description;

    

    public DiscountsResponse getDiscountInfo() {
		return discountInfo;
	}
	public void setDiscountInfo(DiscountsResponse discountInfo) {
		this.discountInfo = discountInfo;
	}
	public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, discountInfo, name, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(description, other.description) && Objects.equals(discountInfo, other.discountInfo)
				&& Objects.equals(name, other.name) && Objects.equals(price, other.price);
	}
	@Override
	public String toString() {
		return "Product [discountInfo=" + discountInfo + ", name=" + name + ", price=" + price + ", description="
				+ description + "]";
	}
  

    
}
