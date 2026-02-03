import java.util.ArrayList;

public class Box implements Packable{
    
    private double capacity;
    private ArrayList<Packable> items;

    public Box(double capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public void add(Packable item) {
        if (item.weight() > freeSpace()) {
            return;
        }
        items.add(item);
    }

    @Override
    public double weight() {
        double weightItems = 0;
        for (Packable temp : items) {
            weightItems += temp.weight();
        }
        return weightItems;
    }

    public double freeSpace() {
        return this.capacity - weight();
    }

    public String toString() {
        return "Box: " + items.size() + " items, total weight " + weight() + " kg";
    }
}
