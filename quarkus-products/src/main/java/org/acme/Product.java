package org.acme;

public class Product {
    
    private DiscountsResponse discountInfo;
    private String name;
    private String price;

    

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
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((discountInfo == null) ? 0 : discountInfo.hashCode());
        return result;
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
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        if (discountInfo == null) {
            if (other.discountInfo != null)
                return false;
        } else if (!discountInfo.equals(other.discountInfo))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Products [name=" + name + ", discounts=" + discountInfo + "]";
    }

    
}
