package service;

public interface StoreService {
    void showProduct();

    void addProduct(String product, Integer price, Integer total);

    void outProduct(String prduct, Integer price);

    void outProduct2(String product, Integer total);
}
