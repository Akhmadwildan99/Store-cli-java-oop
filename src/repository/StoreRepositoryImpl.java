package repository;

import entity.Product;
import entity.ProductPrice;
import entity.ProductTotal;

import java.util.Arrays;

public class StoreRepositoryImpl implements StoreRepository{
    private Product[] products = new Product[10];

    private ProductPrice[] prices = new ProductPrice[10];

    private ProductTotal[] totals = new ProductTotal[10];

    private int size = 0;

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
        var exist = false;
        for (var item : products) {
            if (product.equals(item)) {
                exist = true;
            }
        }
        return exist;
    }

    // Cari index jika product is exist

    public int getIndexIfExist(Product[] products,Product product){
        int index = 0;
        for (int i = 0; i < products.length; i++) {
            if (product.equals(products[i])){
                index = i;
                break;
            }
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
    public boolean add(Product product, ProductPrice price, ProductTotal total) {

        if (isExist(product)){
            return false;
        } else {
            reSizeIfFull();
            products[size] = product;
            totals[size] = total;
            prices[size] = price;
            size ++;
            return true;
        }
    }

    @Override
    public boolean updateTotal(Product product, ProductTotal total){
        if (isExist(product)){
            int index = getIndexIfExist(products, product);
            if (totals[index].getTotal() == 0){
                totals[index] = total;
                return true;
            }
        }
        return false;
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
