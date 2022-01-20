package test.testView;

import repository.StoreRepository;
import repository.StoreRepositoryImpl;
import service.StoreService;
import service.StoreServiceImpl;
import view.StoreView;

public class TestView {
    public static void main(String[] args) {
        testShowProduct();
    }

    public static void testShowProduct(){
        StoreRepository storeRepository = new StoreRepositoryImpl();
        StoreService storeService = new StoreServiceImpl(storeRepository);
        StoreView storeView = new StoreView(storeService);
        storeService.addProduct("Mizone", 4000, 50);
        storeService.addProduct("Pocari", 5000, 60);
        storeService.addProduct("Teh pucuk", 6000, 50);
        storeService.addProduct("Indomie", 3000, 40);
        storeService.addProduct("Supermie", 3000, 400);
        storeService.addProduct("Sarimi", 2000, 50);
        storeService.addProduct("Real good", 1000, 90);
        storeService.addProduct("Sonice", 1000, 1000);
        storeService.addProduct("Gulaku", 9000, 500);
        storeService.addProduct("Malkis", 1000, 300);
        storeService.addProduct("Roma Gandum", 5000, 500);
        storeService.addProduct("Roma Gandum", 9000, 500);
        storeView.showProducts();
    }

    public static void testViewAddProduct(){
        StoreRepository storeRepository = new StoreRepositoryImpl();
        StoreService storeService = new StoreServiceImpl(storeRepository);
        StoreView storeView = new StoreView(storeService);
        storeService.addProduct("Mizone", 4000, 50);
        storeService.addProduct("Pocari", 5000, 60);
        storeService.addProduct("Teh pucuk", 6000, 50);
        storeService.showProduct();
        storeView.addProduct();
        storeService.showProduct();
    }

    public static void testViewCheckout1(){
        StoreRepository storeRepository = new StoreRepositoryImpl();
        StoreService storeService = new StoreServiceImpl(storeRepository);
        StoreView storeView = new StoreView(storeService);
        storeService.addProduct("Mizone", 4000, 50);
        storeService.addProduct("Pocari", 5000, 60);
        storeService.addProduct("Teh pucuk", 6000, 50);
        storeService.showProduct();
        storeView.checkOutWithPrice();
        storeService.showProduct();
    }

    public static void testViewCheckout2(){
        StoreRepository storeRepository = new StoreRepositoryImpl();
        StoreService storeService = new StoreServiceImpl(storeRepository);
        StoreView storeView = new StoreView(storeService);
        storeService.addProduct("Mizone", 4000, 50);
        storeService.addProduct("Pocari", 5000, 60);
        storeService.addProduct("Teh pucuk", 6000, 50);
        storeService.showProduct();
        storeView.checkOutWithTotal();
        storeService.showProduct();
    }
}
