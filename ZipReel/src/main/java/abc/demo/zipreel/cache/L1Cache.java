package abc.demo.zipreel.cache;

import java.util.LinkedHashMap;
import java.util.Map;

//LRU implementation
public class L1Cache<K,V> extends Cache<K, V>{
    private LinkedHashMap<K,V> lrucache;
    private int l1CacheHitCounter;
    private int l1CacheMissCounter;

    public L1Cache(int capacity) {
        super(capacity);
        lrucache = new LinkedHashMap<>(capacity, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size()>capacity;
            }
        };
    }

    @Override
    public void remove(K key) {
        lrucache.remove(key);
        cacheMap.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return lrucache.containsKey(key);
    }

    @Override
    public void put(K key, V value) {
        lrucache.put(key,value);
        cacheMap.put(key, value);
    }

    @Override
    public void stats() {
        System.out.println("L1 cache hits : "+l1CacheHitCounter);
        System.out.println("L1 cache miss: "+l1CacheMissCounter);
        System.out.println("L1 cache data : "+lrucache);
    }

    @Override
    public V get(K key) {
         if(lrucache.containsKey(key))
             l1CacheHitCounter++;
         else
            l1CacheMissCounter++;
         return lrucache.getOrDefault(key, null);
    }
}
