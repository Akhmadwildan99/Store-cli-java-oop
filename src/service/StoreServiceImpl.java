package service;

import entity.Product;
import entity.ProductPrice;
import entity.ProductTotal;
import repository.StoreRepository;
import repository.StoreRepositoryImpl;

public class StoreServiceImpl implements StoreService{
    private StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public void showProduct() {
        Product[] products = storeRepository.getAllProduct();
        ProductPrice[] prices = storeRepository.getAllPrice();
        ProductTotal[] totals = storeRepository.getAllTotal();

        System.out.println("STORE PRODUCTS");

        for (int i = 0; i < products.length ; i++) {
            var product = products[i];
            var price = prices[i];
            var total = totals[i];

            var no = i + 1;

            if (product != null && price != null && total != null){
                System.out.println(no + ". " + "Product: "+ product.getProduct() + " || "+"Price: " + price.getPrice() + " || "+"Total: " + total.getTotal());
            }
        }
    }

    @Override
    public void addProduct(String product, Integer price, Integer total) {
        Product productName = new Product(product);
        ProductPrice productPrice = new ProductPrice(price);
        ProductTotal productTotal = new ProductTotal(total);
        var success = storeRepository.add(productName, productPrice, productTotal);
        if (success){
            System.out.println("Sukses menambah product: " + productName.getProduct());
        } else {
            var successUpdate = storeRepository.updateTotal(productName, productTotal);
            if (successUpdate){
                System.out.println("Update jumlah product: " + productName.getProduct());
            } else {
                System.out.println("Gagal menambah atau Update jumlah product: " + productName.getProduct());
            }
        }

    }

    @Override
    public void outProduct() {

    }
}
