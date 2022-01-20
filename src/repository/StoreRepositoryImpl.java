package repository;

import entity.Product;

public class StoreRepositoryImpl implements StoreRepository{
    private Product[] products = new Product[10];

//    private ProductPrice[] prices = new ProductPrice[10];
//
//    private ProductTotal[] totals = new ProductTotal[10];
    private Integer[] prices = new Integer[10];

    private Integer[] totals = new Integer[10];

    private int size = 0;

    @Override
    public Product[] getAllProduct() {
        return products;
    }

//    @Override
//    public ProductPrice[] getAllPrice() {
//        return prices;
//    }
//
//    @Override
//    public ProductTotal[] getAllTotal() {
//        return totals;
//    }

    public Integer[] getAllPrice(){
        return prices;
    }

    public  Integer[] getAllTotal(){
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
//            prices = new ProductPrice[prices.length * 2];
//            totals = new ProductTotal[totals.length * 2];
                prices = new Integer[prices.length * 2];
                totals = new Integer[totals.length * 2];

            for (int i = 0; i < tempProduct.length; i++) {
                products[i] = tempProduct[i];
                prices[i] = tempPrice[i];
                totals[i] = tempTotal[i];
            }
        }
    }

    public boolean checkIfNull(Product product, Integer price, Integer total){
        if (product.getProduct() == null || price == null || total == null){
            return true;
        } else if (product.getProduct().isBlank() || price == 0 || total == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean add(Product product, Integer price, Integer total) {

        if (isExist(product)){
            return false;
        } else {
            boolean check = checkIfNull(product, price, total);
            if (check){
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
    }

    @Override
    public boolean updateTotal(Product product, Integer price,Integer total){
        if (isExist(product)){
            int index = getIndexIfExist(products, product);
            if (price.equals(prices[index])){
                totals[index] += total;
                System.out.println("stock " + product.getProduct() + " diupdate menjadi: " + totals[index]);
                return true;
            } else{
                return false;
            }

        }
        return false;
    }

    @Override
    public boolean out(Product product, Integer price) {
        if (isExist(product)){
            int index = getIndexIfExist(products, product);
            if (price < prices[index]){
                System.out.println("Duit anda kurang!!");
                return false;
            } else {
                int getProduct = 0;
                Integer remainder = price;

                while(remainder >= prices[index]){
                    getProduct += 1;
                    remainder -= prices[index];
                }

                if (getProduct > totals[index]){
                    System.out.println("Stock produk kurang dari jumlah yang anda mau!!");
                    return false;
                }

                totals[index] -= getProduct;
                var remove = removeStock(totals[index], index, product);
                if (!remove){
                    System.out.println("Sisa stock " + product.getProduct() + ": " +totals[index]);
                    System.out.println("Kembalian anda: "+ remainder);
                }
                return true;
            }

        }
        return false;
    }

    public boolean removeStock(Integer total, int index, Product product){
        if (total < 0){
            return false;
        } else if (total == 0){
            for (int i = index; i < size; i++) {
                products[i] = products[i + 1];
                prices[i] = prices[i + 1];
                totals[i] = totals[i + 1];
            }
            size--;
            System.out.println("Stock " + product.getProduct() + " sekarang kosong!");
            return true;
        }

        return  false;

    }

    @Override
    public boolean out2(Product product, Integer total) {
        if (isExist(product)){
            int index = getIndexIfExist(products, product);
            if (totals[index] < total){
                System.out.println("Maaf stock kami kurang dari jumlah yang anda mau!!");
                return false;
            } else{
                Integer reminderProduct = totals[index] - total;
                int totalPrice = total * prices[index];
                totals[index] = reminderProduct;
                var remove = removeStock(reminderProduct, index, product);
                System.out.println("Jumlah harga " + product.getProduct() + ": " + totalPrice );
                if (!remove){
                    System.out.println("Sisa stock product " + product.getProduct() + ": " + reminderProduct);
                }
                return true;
            }
        }
        return false;
    }

    public int getSize(){
        return size;
    }


}
