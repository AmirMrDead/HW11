package question_4;

import java.util.Arrays;

public class HashMapImpl<K, V> implements MyHashMap<K, V> {

    private K[] keys;
    private V[] values;
    private int index = 0;
    private final int initialCapacity;
    private final float loadFactor;

    public HashMapImpl() {
        loadFactor = 0.75f;
        initialCapacity = 16;
        keys = (K[]) new Object[initialCapacity];
        values = (V[]) new Object[initialCapacity];
    }

    public HashMapImpl(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("initial capacity must not negative");
        this.initialCapacity = initialCapacity;
        loadFactor = 0.75f;
        keys = (K[]) new Object[initialCapacity];
        values = (V[]) new Object[initialCapacity];
    }

    public HashMapImpl(float loadFactor) {
        if (loadFactor > 1 || loadFactor < 0)
            throw new IllegalArgumentException("load factor must be between 0 and 1");
        this.loadFactor = loadFactor;
        initialCapacity = 16;
        keys = (K[]) new Object[initialCapacity];
        values = (V[]) new Object[initialCapacity];
    }

    public HashMapImpl(int initialCapacity, float loadFactor) {
        if (loadFactor > 1 || loadFactor < 0)
            throw new IllegalArgumentException("load factor must be between 0 and 1");
        if (initialCapacity < 0)
            throw new IllegalArgumentException("initial capacity must not negative");
        this.initialCapacity = initialCapacity;
        this.loadFactor = loadFactor;
        keys = (K[]) new Object[initialCapacity];
        values = (V[]) new Object[initialCapacity];
    }

    @Override
    public void put(K key, V value) {
        if (duplicateKey(key))
            return;
        keys[index] = key;
        values[index++] = value;
    }

    @Override
    public boolean containKey(K key) {
        return duplicateKey(key);
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public boolean replace(K oldKey, K newKey, V newValue) {
        int replace = remove(oldKey);
        if (replace == -1)
            return false;
        keys[replace] = newKey;
        values[replace] = newValue;
        return true;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < index; i++) {
            result += keys[i] + " => " + values[i] + '\n';
        }
        return result;
    }

    private int remove(K key) {
        int rm = -1;
        for (int i = 0; i < index; i++)
            if (key == keys[i]) {
                return i;
            }
        return -1;
    }

    private boolean duplicateKey(K key) {
        if (index >= initialCapacity * loadFactor) {
            keys = Arrays.copyOf(keys, index * 2);
            values = Arrays.copyOf(values, index * 2);
        }
        for (int i = 0; i < index; i++) {
            if (keys[i] == key)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> myHashMap = new HashMapImpl<>(1, 0.16f);
        myHashMap.put("a", 1);
        myHashMap.put("b", 1);
        myHashMap.put("c", 1);
        System.out.println(myHashMap);
        System.out.println(myHashMap.replace("a", "e", 5));
        System.out.println(myHashMap.containKey("e"));
        System.out.println(myHashMap.isEmpty());
        System.out.println("\n" + myHashMap);
    }

}
