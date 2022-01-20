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
            System.out.println("");
            storeService.showProduct();
            System.out.println("");
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

        System.out.println(" ");
        System.out.println("MENAMBAH PRODUCT!!");

        var inputProduct = InputUtil.input("Masukan product (x jika batal): ");
        var inputPrice = InputUtil.input("Masukan harga: ");
        var inputTotal = InputUtil.input("masukan total: ");

        System.out.println(" ");

        if (inputProduct.equals("x") ){
            //false
        } else {
            storeService.addProduct(inputProduct.toLowerCase(), Integer.valueOf(inputPrice), Integer.valueOf(inputTotal));
        }

    }

    public void checkOutWithPrice(){
        System.out.println(" ");
        System.out.println("CHECK-OUT DENGAN JUMLAH UANG!!");
        var inputProduct = InputUtil.input("Masukan product (x jika batal): ");
        var inputPrice = InputUtil.input("Masukan jumlah uang: ");

        System.out.println(" ");

        if (inputProduct.equals("x") ){
            //false
        } else {
            storeService.outProduct(inputProduct.toLowerCase(), Integer.valueOf(inputPrice));
        }
    }

    public void checkOutWithTotal(){
        System.out.println(" ");
        System.out.println("CHECK-OUT DENGAN JUMLAH YANG MAU ANDA BELI!!");
        var inputProduct = InputUtil.input("Masukan product (x jika batal): ");
        var inputTotal = InputUtil.input("masukan total beli: ");

        System.out.println(" ");

        if (inputProduct.equals("x") ){
            //false
        } else {
            storeService.outProduct2(inputProduct.toLowerCase(), Integer.valueOf(inputTotal));
        }
    }
}
