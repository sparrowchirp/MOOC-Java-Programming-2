import java.util.ArrayList;

public class BoxWithMaxWeight extends Box{
    private int maxWeight;
    private ArrayList<Item> items;

    public BoxWithMaxWeight(int capacity) {
        this.maxWeight = capacity;
        this.items = new ArrayList<>();
    }

    public int spaceLeft() {
        int totalWeight = 0;
        for (Item temp : items) {
            totalWeight += temp.getWeight();
        }
        return maxWeight - totalWeight;
    }

    @Override
    public void add(Item item) {
        if(item.getWeight() > this.spaceLeft()) {
            return;
        }
        this.items.add(item);
    }
    
    @Override
    public boolean isInBox(Item item) {
        return this.items.contains(item);
    }
}
