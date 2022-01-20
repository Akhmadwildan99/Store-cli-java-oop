package util;

import entity.Product;
import execption.BlankException;

public class ValidationUtil {
    public static void validate(Product product, Integer price, Integer total){
        if(product.getProduct() == null){
            throw new NullPointerException("product is null");
        } else if (product.getProduct().isBlank()){
            throw new BlankException("product is blank!");
        } else if (price == null || total == null){
            throw new NullPointerException("Price or Total is null");
        } else if (price == 0 || total == 0){
            throw new IllegalArgumentException("Not allow to sign value zero!");
        }
    }
}
