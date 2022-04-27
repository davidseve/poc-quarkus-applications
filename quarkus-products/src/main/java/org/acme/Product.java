package org.acme;

import java.util.Set;

public class Product {
    
    private Set<Discount> discounts;
    private String name;

    
    public Set<Discount> getDiscounts() {
        return discounts;
    }
    public void setDiscounts(Set<Discount> discounts) {
        this.discounts = discounts;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((discounts == null) ? 0 : discounts.hashCode());
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
        if (discounts == null) {
            if (other.discounts != null)
                return false;
        } else if (!discounts.equals(other.discounts))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Products [name=" + name + ", discounts=" + discounts + "]";
    }

    
}
