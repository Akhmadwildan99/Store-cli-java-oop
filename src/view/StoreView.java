package view;

import service.StoreService;
import util.InputUtil;

public class StoreView {
    private StoreService storeService;

    public StoreView(StoreService storeService) {
        this.storeService = storeService;
    }

    public void showProducts(){
        while (true){
            storeService.showProduct();

            System.out.println("Menu:");
            System.out.println("1) TAMBAH PEODUK");
            System.out.println("2) CHECK OUT (dengan sejumlah uang)");
            System.out.println("3) CHECK OUT (dengan menyebutkan berapa total yang mau dibeli)");
            System.out.println("x) cancel");

            var input = InputUtil.input("masukan pilihan: ");

            if (input.equals("1")){
                addProduct();
            } else if (input.equals("2")){
                checkOutWithPrice();
            } else if (input.equals("3")){
                checkOutWithTotal();
            } else if (input.equals("x")){
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti!!");
            }
        }

    }

    public void addProduct(){

    }

    public void checkOutWithPrice(){

    }

    public void checkOutWithTotal(){

    }
}
