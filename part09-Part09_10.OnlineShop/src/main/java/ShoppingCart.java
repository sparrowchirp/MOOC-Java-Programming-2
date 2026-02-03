import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Item> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }
    
    public void add(String product, int price) {
        this.items.putIfAbsent(product, new Item(product, 0, price));
        this.items.get(product).increaseQuantity();
    }
    
    public int price() {
        int price = 0;
        for (Item temp : items.values()) {
            price += temp.price();
        }
        return price;
    }

    public void print() {
        for(Item temp : items.values()) {
            System.out.println(temp);
        }
    }
}
