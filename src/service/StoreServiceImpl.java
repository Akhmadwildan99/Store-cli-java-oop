package service;

import entity.Product;
import entity.ProductPrice;
import entity.ProductTotal;
import execption.BlankException;
import repository.StoreRepository;
import repository.StoreRepositoryImpl;
import util.ValidationUtil;

public class StoreServiceImpl implements StoreService{
    private StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public void showProduct() {
        Product[] products = storeRepository.getAllProduct();
        Integer[] prices = storeRepository.getAllPrice();
        Integer[] totals = storeRepository.getAllTotal();

        System.out.println(" ");
        System.out.println("STORE PRODUCTS");

        for (int i = 0; i < products.length ; i++) {
            var product = products[i];
            var price = prices[i];
            var total = totals[i];

            var no = i + 1;

            if (product != null || price != null || total != null){
                System.out.println(no + ". " + "Product: "+ product.getProduct() + " || "+"Price: " + price + " || "+"Total: " + total);
            }
        }
    }


    @Override
    public void addProduct(String product, Integer price, Integer total) {
        Product productName = new Product(product);
//        ProductPrice productPrice = new ProductPrice(price);
//        ProductTotal productTotal = new ProductTotal(total);
        try{
            ValidationUtil.validate(productName, price, total);
        } catch (NullPointerException | BlankException | IllegalArgumentException exception){
            System.out.println("Error " + exception.getMessage());
        }

        var success = storeRepository.add(productName, price, total);
        if (success){
            System.out.println("Sukses menambah product: " + productName.getProduct());
        } else {
            var successUpdate = storeRepository.updateTotal(productName, price,total);
            if (successUpdate){
                System.out.println("Update jumlah product: " + productName.getProduct());
            } else {
                System.out.println("Gagal menambah atau Update jumlah product: " + productName.getProduct());
            }
        }

    }

    @Override
    public void outProduct(String product, Integer price) {
        Product productName = new Product(product);
//        ProductPrice productPrice = new ProductPrice(price);
        var success = storeRepository.out(productName, price);
        if (success){
            System.out.println("PROSES SUKSES");
        } else {
            System.out.println("PROSES GAGAL");
        }
    }

    @Override
    public void outProduct2(String product, Integer total) {
        Product productName = new Product(product);
        var success = storeRepository.out2(productName, total);
        if (success){
            System.out.println("PROSES SUKSES");
        } else {
            System.out.println("PROSES GAGAL");
        }
    }
}
