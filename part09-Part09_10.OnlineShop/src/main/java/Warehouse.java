import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse {

    private Map<String, Integer> products;
    private Map<String, Integer> productsBalance;

    public Warehouse() {
        this.products = new HashMap<>();
        this.productsBalance = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        this.products.put(product, price);
        this.productsBalance.put(product, stock);
    }
    
    public int price(String product) {
        return products.getOrDefault(product, -99);
    }

    public int stock(String product) {
        return productsBalance.getOrDefault(product, 0);
    }

    public boolean take(String product) {
        Integer stock = this.productsBalance.get(product);
        if (products.containsKey(product) && stock > 0) {
            productsBalance.put(product, stock - 1);
            return true;
        }
        return false;
    }

    public Set<String> products() {
        return products.keySet();
    }
}
