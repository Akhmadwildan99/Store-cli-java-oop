package entity;

import java.util.Objects;

public class Product {
    private String product;


    public Product() {
    }

    public Product(String product) {
        this.product = product;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product1 = (Product) o;
        return Objects.equals(product, product1.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }
}
