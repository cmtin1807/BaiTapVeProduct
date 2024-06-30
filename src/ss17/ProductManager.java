package ss17;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> productManager;
    public ProductManager() {
        productManager = new ArrayList<Product>();
    }
    public void addProduct(Product product) {
        productManager.add(product);
    }
    public List<Product> getProducts() {
        return productManager;
    }
    public int getLastId(){
        if(productManager.isEmpty()){
            return 0;
        }
        return productManager.get(productManager.size()-1).getId();
    }
    public void printAllProducts() {
        for (Product product : productManager) {
            System.out.println(product);
        }
    }
}
