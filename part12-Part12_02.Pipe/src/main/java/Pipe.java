import java.util.ArrayDeque;
import java.util.Queue;

public class Pipe<T> {
    private Queue<T> items;

    public Pipe() {
        this.items = new ArrayDeque<>();
    }

    public void putIntoPipe(T value) {
        this.items.add(value);
    }

    public T takeFromPipe() {
        return this.items.poll();
    }

    public boolean isInPipe() {
        return !this.items.isEmpty();
    }
    
}
