import java.util.ArrayList;
import java.util.List;

public class Herd implements Movable {
    private List<Movable> objects;

    public Herd() {
        this.objects = new ArrayList<>();
    }

    public void addToHerd(Movable movable) {
        objects.add(movable);
    }

    public void move(int dx, int dy) {
        for (Movable temp : objects) {
            temp.move(dx, dy);
        }
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Movable temp : objects) {
            output.append(temp.toString());
            output.append("\n");
        }
        return output.toString();
    }
}
