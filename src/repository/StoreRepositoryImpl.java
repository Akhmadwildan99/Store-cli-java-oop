package repository;

import entity.Product;
import entity.ProductPrice;
import entity.ProductTotal;

public class StoreRepositoryImpl implements StoreRepository{
    public Product[] products = new Product[10];

    public ProductPrice[] prices = new ProductPrice[10];

    public ProductTotal[] totals = new ProductTotal[10];

    @Override
    public Product[] getAllProduct() {
        return products;
    }

    @Override
    public ProductPrice[] getAllPrice() {
        return prices;
    }

    @Override
    public ProductTotal[] getAllTotal() {
        return totals;
    }

    @Override
    public void add(Product product, ProductPrice price, ProductTotal total) {

    }

    @Override
    public boolean out(Product product, ProductPrice price) {
        return false;
    }

    @Override
    public boolean out2(Product product, ProductTotal total) {
        return false;
    }
}
