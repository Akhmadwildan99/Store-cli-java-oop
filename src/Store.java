import repository.StoreRepository;
import repository.StoreRepositoryImpl;
import service.StoreService;
import service.StoreServiceImpl;
import view.StoreView;

public class Store {
    public static void main(String[] args) {
        StoreRepository storeRepository = new StoreRepositoryImpl();
        StoreService storeService = new StoreServiceImpl(storeRepository);
        StoreView storeView = new StoreView(storeService);
        storeView.showProducts();
    }
}
