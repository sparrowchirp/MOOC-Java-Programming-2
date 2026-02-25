import java.util.ArrayList;

public class HashMap<K, V> {
    private ArrayList<Pair <K, V>>[] values;
    private int quantityOfStoredElements;

    public HashMap() {
        this.values = (ArrayList<Pair <K, V>>[]) new ArrayList[16];
        this.quantityOfStoredElements = 0;
    }

    public V get(K key) {
        int hashValue = hashValue(key);

        if (values[hashValue] == null) {
            return null;
        }

        ArrayList<Pair<K, V>> listAtIndex = this.values[hashValue];
        for( Pair<K, V> temp : listAtIndex) {
            if (temp.getKey().equals(key)) {
                return temp.getValue();
            }
        }
        return null;
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public int hashValue(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        return (key.hashCode() & (this.values.length - 1));
    }

    public void add (K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key and value cannot be null");
        }
        ArrayList<Pair <K, V>> listAtIndex = getListBasedOnKey(key);
        int index = getIndexBasedonKey(listAtIndex, key);

        if (index < 0) {
            listAtIndex.add(new Pair<>(key, value));
            this.quantityOfStoredElements++;
        } else {
            listAtIndex.get(index).setValue(value);
        }

        if (this.quantityOfStoredElements * 1.0 > this.values.length * 0.75) {
            grow();
        }
    }

    private ArrayList<Pair<K, V>> getListBasedOnKey(K key) {
        int hashValue = hashValue(key);
        if (this.values[hashValue] == null) {
            this.values[hashValue] = new ArrayList<>();
        }

        return this.values[hashValue];
    }

    private int getIndexBasedonKey(ArrayList<Pair<K, V>> list, K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private void grow() {
        ArrayList<Pair<K, V>>[] newList = (ArrayList<Pair<K, V>>[]) new ArrayList[this.values.length * 2];

        for (int i = 0; i < this.values.length; i++) {
            copy(newList, i);
        }

        this.values = newList;
    }

    private void copy(ArrayList<Pair<K, V>>[] newList, int indexOfBucketToCopy) {
        ArrayList<Pair<K, V>> valuesAtIndex = this.values[indexOfBucketToCopy];
        if(valuesAtIndex == null) {
            return;
        }

        for(int i = 0; i < valuesAtIndex.size(); i++){
            Pair<K, V> pair = valuesAtIndex.get(i);
            int hashValue = pair.getKey().hashCode() & (newList.length - 1);
            if (newList[hashValue] == null) {
                newList[hashValue] = new ArrayList<>();
            }
            newList[hashValue].add(pair);
        }
    }

    public V remove(K key) {
        int hash = hashValue(key);
        ArrayList<Pair<K, V>> list = this.values[hash];

        if (list == null) {
            return null;
        }
        int index = getIndexBasedonKey(list, key);
        if(index < 0) {
            return null;
        }
        
        Pair<K, V> pair = list.get(index);

        list.remove(index);
        this.quantityOfStoredElements--;
        return pair.getValue();
    }

    
}
