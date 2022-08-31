package question_4;

public interface MyHashMap<K, V> {

    boolean put(K key, V value);

    boolean containKey(K key);

    boolean isEmpty();

    boolean replace(K oldKey, K newKey, V newValue);
}
