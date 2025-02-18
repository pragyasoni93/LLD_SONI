package abc.demo.zipreel.cache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

abstract class Cache<K,V> {
    protected int capacity;
    protected Map<K,V> cacheMap;

    Cache(int capacity){
        this.capacity = capacity;
        this.cacheMap = new LinkedHashMap<>(capacity);
    }

    public abstract void remove(K key);

    public abstract boolean contains(K key);

    public abstract void put(K key, V value);

    public abstract void stats();

    public abstract V get(K key);
}
