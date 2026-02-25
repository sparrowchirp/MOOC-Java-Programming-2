public class Hideout<T> {
    private T item;

    public Hideout() {
    }

    public void putIntoHideout(T toHide) {
        this.item = toHide;
    }

    public T takeFromHideout() {
        T output = this.item;
        this.item = null;
        return output;
    }

    public boolean isInHideout() {
        return this.item != null;
    }
}
