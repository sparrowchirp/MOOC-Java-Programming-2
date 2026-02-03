public class Item {
    
    private String name;
    private int qty;
    private int unitPrice;

    public Item(String name, int qty, int unitPrice) {
        this.name = name;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }
    public int price() {
        return this.unitPrice * this.qty;
    }

    public void increaseQuantity() {
        qty++;
    }

    public String toString() {
        return name + ": " + qty;
    }
}
