package repository;

import entity.Product;

public interface StoreRepository {
    Product[] getAllProduct();

    Integer[] getAllPrice();

    Integer[] getAllTotal();

    boolean add(Product product, Integer price, Integer total);

    boolean updateTotal(Product product,Integer price, Integer total);

    boolean out(Product product, Integer price);

    boolean out2(Product product, Integer total);
}
