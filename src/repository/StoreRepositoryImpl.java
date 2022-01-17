package repository;

import entity.Product;
import entity.ProductPrice;
import entity.ProductTotal;

import java.util.Arrays;

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

    // Cek apakah ada produk yang eksis dalam array
    public boolean isExist(Product product){
        var notExist = false;
        for (var item : products){
            if (product.equals(item)){
                notExist = true;
                break;
            }
        }
        return notExist;
    }

    // Cari index jika product is exist

    public int getIndexIfExist(Product product){
        int index = 0;
        if (isExist(product)){
           index = Arrays.binarySearch(products, product);
        }

        return index;
    }

    // Cek array is full
    public boolean isFull(){
        var isFull = true;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null){
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    // resize array jika full
    public void reSizeIfFull(){
        if (isFull()){
            var tempProduct = products;
            var tempPrice = prices;
            var tempTotal = totals;
            
            products = new Product[products.length * 2];
            prices = new ProductPrice[prices.length * 2];
            totals = new ProductTotal[totals.length * 2];

            for (int i = 0; i < tempProduct.length; i++) {
                products[i] = tempProduct[i];
                prices[i] = tempPrice[i];
                totals[i] = tempTotal[i];
            }
        }
    }

    @Override
    public void add(Product product, ProductPrice price, ProductTotal total) {
        reSizeIfFull();
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null){
                products[i] = product;
                totals[i] = total;
                prices[i] = price;
                break;
            }
        }

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
