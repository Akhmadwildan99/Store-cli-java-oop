package test.service;

import entity.Product;
import entity.ProductPrice;
import entity.ProductTotal;
import repository.StoreRepository;
import repository.StoreRepositoryImpl;
import service.StoreService;
import service.StoreServiceImpl;

public class StoreServiceTest {
    public static void main(String[] args) {
        testAddProduct();
    }

    public static void testShowSProduct(){
        StoreRepositoryImpl repository = new StoreRepositoryImpl();

//        repository.products[0] = new Product("Permen");
//        repository.prices[0] = new ProductPrice(500);
//        repository.totals[0] = new ProductTotal(10);
//        repository.products[1] = new Product("Snack");
//        repository.prices[1] = new ProductPrice(500);
//        repository.totals[1] = new ProductTotal(20);
//        repository.products[2] = new Product("Indomie");
//        repository.prices[2] = new ProductPrice(3000);
//        repository.totals[2] = new ProductTotal(10);

        StoreService service = new StoreServiceImpl(repository);
        service.showProduct();
    }

    public static void testAddProduct(){
        StoreRepository repository = new StoreRepositoryImpl();
        StoreService service = new StoreServiceImpl(repository);

        service.addProduct("Permen", 500, 30);
        service.addProduct("Indomie", 3000, 30);
        service.addProduct("Susu", 5000, 70);
        service.showProduct();

        service.addProduct("Susu", 5000, 30);
        service.addProduct("Indomie", 3000, 30);

        service.showProduct();
    }

    public static void testOutProductFirst(){
        StoreRepository repository = new StoreRepositoryImpl();
        StoreService service = new StoreServiceImpl(repository);

        service.addProduct("Permen", 500, 30);
        service.addProduct("Indomie", 3000, 30);
        service.addProduct("Susu", 5000, 50);

        service.showProduct();

        service.outProduct("Susu", 34000);
        service.outProduct("Indomie", 8000);

        service.showProduct();
    }
}
