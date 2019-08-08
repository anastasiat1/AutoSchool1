package buisnessObjects;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private static List<Product> list = new ArrayList<>();

    private Product(){
    }

    public static void createObject(String name){
        Product productFromCatalog = new Product();
        productFromCatalog.setName(name);
        list.add(productFromCatalog);
    }

    public static Product getFirstProduct(){
        return list.get(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}