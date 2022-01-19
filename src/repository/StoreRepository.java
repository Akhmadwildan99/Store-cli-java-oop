package repository;

import entity.Product;
import entity.ProductPrice;
import entity.ProductTotal;

public interface StoreRepository {
    Product[] getAllProduct();

//    ProductPrice[] getAllPrice();
//
//    ProductTotal[] getAllTotal();
    Integer[] getAllPrice();

    Integer[] getAllTotal();

    boolean add(Product product, Integer price, Integer total);

    boolean updateTotal(Product product,Integer price, Integer total);

    boolean out(Product product, Integer price);

    boolean out2(Product product, Integer total);
}
