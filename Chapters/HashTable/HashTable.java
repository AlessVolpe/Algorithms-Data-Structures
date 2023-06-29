package HashTable;

import java.security.InvalidKeyException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;


// A hash table with linear probing and the MAD hash function
public class HashTable implements Map<Object, Object> {
    protected static class HashEntry implements Entry<Object, Object> {
        Object key, value;

        HashEntry() {/* default constructor */}
        HashEntry(Object k, Object v) { key = k; value = v; }

        public Object getKey() { return key; }
        public Object getValue() { return value; }

        public String toString() {
            return "(" + getKey() + ", " + getValue() + ")";
        }

        // sets a new value and returns the old one
        // on the slides the functions visibility is for some reason set to protected
        @Override
        public Object setValue(Object v) {
            Object temp = value;
            value = v;
            return temp; // returns the old value
        }
    }

    // Default equality tester
    protected static class DefaultEqualityTester implements EqualityTester<Object> {
        DefaultEqualityTester() {/* default constructor */}
        // returns whether two objects are equal
        public boolean isEqualTo(Object a, Object b) { return a.equals(b); }
    }

    protected static Entry<Object, Object> AVAILABLE = new HashEntry(null, null); // empty marker
    protected int entryNumber = 0, capacity; // number of entries in the dictionary and capacity of the bucket
    protected Entry<Object, Object>[] bucketArray;
    protected EqualityTester<Object> et;
    protected int scale, shift; // shift and scale factors

    // Creates hash table with initial capacity of 1023
    @SuppressWarnings("unchecked")
    public HashTable() {
        capacity = 1023; // default capacity
        bucketArray = (Entry<Object, Object>[]) new Entry[capacity];
        et = new DefaultEqualityTester();
        Random rand = new Random();
        scale = rand.nextInt(capacity - 1) + 1;
        shift = rand.nextInt(capacity);
    }

    // Creates hash table with given capacity and equality tester
    @SuppressWarnings("unchecked")
    public HashTable(int inputCapacity, EqualityTester<Object> tester) {
        capacity = inputCapacity;
        bucketArray = (Entry<Object, Object>[]) new Entry[capacity];
        et = tester;
        Random rand = new Random();
        scale = rand.nextInt(capacity - 1) + 1;
        shift = rand.nextInt(capacity);
    }
    
    // Checks if a key is valid or not
    protected void checkKey(Object k) throws InvalidKeyException {
        if (k == null) throw new InvalidKeyException("Invalid key: null");
    }

    // Hash function applying MAD method to default hash code
    public int hashValue(Object key) {
        return Math.abs(key.hashCode()*scale + shift) % capacity;
    }

    @Override
    public int size() { return entryNumber; }

    @Override
    public boolean isEmpty() { return (entryNumber == 0); }

    // Helper search method -> returns index of found key or -index-1, where index is an empty or available slot
    protected int findEntry(Object key) throws InvalidKeyException {
        int avail = 0;
        checkKey(key);
        int i = hashValue(key), j = i;

        do {
            if (bucketArray[i] == null) return -i - 1;
            if (bucketArray[i] == AVAILABLE) {
                // bucket is deactivated
                avail = i; // remember that this slot is available
                i = (i + 1) % capacity; // keep looking
            } else if (et.isEqualTo(key, bucketArray[i].getKey())) return i; // entry found
            else i = (i + 1) % capacity; // keep looking
        } while (i != j);

        return -avail - 1; // entry is not found
    }

    // returns the value associated with a key
    @Override
    public Object get(Object key) {
        int i = 0;
        try {
            i = findEntry(key); // searches for the given key
            if (i < 0) return null; // if there's no value for the key return null
            return bucketArray[i].getValue(); // else returns the found value
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return null;
        }
        
    }

    // put a key-value pair in the map, replacing previous one if exists
    @Override
    public Object put(Object key, Object value) throws RuntimeException {
        if (entryNumber >= capacity/2)
            try {
                rehash(); // rehash to keep load factor <= 0.5
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            } 
        
        
        int i = 0;
        try {
            i = findEntry(key); // finds the key 

            if (i < 0) {
                // this key doesn't already have a value
                bucketArray[-i-1] = new HashEntry(key, value); // convert to the proper index
                entryNumber++;
                return null; // there was no previous value to return
            } else return ((HashEntry) bucketArray[i]).setValue(value); // set new value and return the old one
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return null;
        } 
    }

    @SuppressWarnings("unchecked")
    protected void rehash() throws InvalidKeyException {
        capacity = 2 * capacity;
        Entry<Object, Object>[] tempBucket = bucketArray;
        bucketArray = (Entry<Object, Object>[]) new Entry[capacity]; // allocate a new version of bucket array twice as big as before
        Random rand = new Random();
        scale = rand.nextInt(capacity - 1) + 1;
        shift = rand.nextInt(capacity);

        for (int i = 0; i  < tempBucket.length; i++) {
            if ((tempBucket[i] != null) && (tempBucket[i] != AVAILABLE)) {
                // if we have a valid entry
                int j = findEntry(tempBucket[i].getKey()); // find the appropriate spot
                bucketArray[-j-1] = tempBucket[i]; // copy into new array
            }
        }
    }

    // removes the key-value pair with a specified key
    @Override
    public Object remove(Object key) {
        try {
            int i = findEntry(key); // finds the key 
            if (i < 0) return null; // nothing to remove
            Object ret = bucketArray[i].getValue();
            bucketArray[i] = AVAILABLE; // mark this slot as deactivated
            entryNumber--;
            return ret;
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return null;
        } 
    }

    // Returns an iterator of keys
    public Iterator<Object> getKeys() {
        List<Object> keys = new LinkedList<Object>();
        
        for (int i = 0; i < capacity; i++) {
            if ((bucketArray[i] != null) && (bucketArray[i] != AVAILABLE)) keys.add(bucketArray[i].getKey());
        }
        return keys.iterator();
    }

    // Returns an iterator of values
    public Iterator<Object> getValues() {
        List<Object> values = new LinkedList<Object>();

        for (int i = 0; i < capacity; i++) {
            if ((bucketArray[i] != null) && (bucketArray[i] != AVAILABLE)) values.add(bucketArray[i].getValue());
        }
        return values.iterator();
    }

    // prints the pairs in the table
    public void printTable() {
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }

        String output = "[";
        for (Object e: entrySet()) output = output + e + ", ";
        output = output.substring(0, output.length() - 2) + "]";
        System.out.println(output);
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Set entrySet() {
        LinkedHashSet<Entry> pairs;

        if (isEmpty()) return null;

        pairs = new LinkedHashSet<Entry>();
        for (int i = 0; i < capacity; i++) {
            if (bucketArray[i] != null) {
                for (Entry e: bucketArray) pairs.add(e);
            }
        }
		return pairs;
    }

    //#region [NotImplemented]
    @Override
    public boolean containsKey(Object key) {
        throw new UnsupportedOperationException("Unimplemented method 'containsKey'");
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Unimplemented method 'containsValue'");
    }

    @Override
    @SuppressWarnings("rawtypes")
    public void putAll(Map m) {
        throw new UnsupportedOperationException("Unimplemented method 'putAll'");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Set keySet() {
        throw new UnsupportedOperationException("Unimplemented method 'keySet'");
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Collection values() {
        throw new UnsupportedOperationException("Unimplemented method 'values'");
    }
    //#endregion [NotImplemented]
}
