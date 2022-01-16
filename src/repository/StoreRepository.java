package repository;

import entity.Product;
import entity.ProductPrice;
import entity.ProductTotal;

public interface StoreRepository {
    Product[] getAllProduct();

    ProductPrice[] getAllPrice();

    ProductTotal[] getAllTotal();

    void add(Product product, ProductPrice price, ProductTotal total);

    boolean out(Product product, ProductPrice price);

    boolean out2(Product product, ProductTotal total);
}
