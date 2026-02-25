public class List<T> {

    private T[] items;
    private int firstFreeIndex;

    public List() {
        this.items = (T[]) new Object[10];
        this.firstFreeIndex = 0;
    }

    public void add (T value) {
        this.items[firstFreeIndex] = value;
        this.firstFreeIndex++;

        if(this.firstFreeIndex == size()) {
            int newCapacity = size() + size() / 2;
            T[] newItems = (T[]) new Object[newCapacity];
            
            for(int i = 0; i <size(); i++) {
                newItems[i] = this.items[i];
            }

            this.items = newItems;
        }
    }

    public int size() {
        return this.firstFreeIndex;
    }

    public boolean contains(T value) {
        return indexOfItem(value) >= 0;
    }

    public int indexOfItem( T value) {
        for(int i = 0; i < this.firstFreeIndex; i++ ){
            if (items[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public void remove (T value) {
        int index = indexOfItem(value);
        if (index < 0) {
            return;
        }

        shiftItemsOneStepLeft(index);
        this.firstFreeIndex--;
    }

    private void shiftItemsOneStepLeft(int index) {
        for(int i = index + 1; i < this.firstFreeIndex; i++) {
            this.items[i - 1] = this.items[i];
        }
    }

    public T value(int index) {
        if (index < 0 || index >= this.firstFreeIndex){
            throw new ArrayIndexOutOfBoundsException("Index " + index + " is outside of the list.");
        }
        return this.items[index];
    }
    
}
