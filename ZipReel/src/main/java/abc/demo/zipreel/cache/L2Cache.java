package abc.demo.zipreel.cache;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class L2Cache<K,V> extends Cache<K,V>{
    private Map<K,Integer> lfucache;
    private PriorityQueue<K> minHeap;
    private int l2CacheHitCounter;
    private int l2CacheMissCounter;

    public L2Cache(int capacity){
        super(capacity);
        lfucache = new HashMap<>();
        minHeap = new PriorityQueue<>(Comparator.comparingInt(lfucache::get));
    }

    @Override
    public void remove(K key) {
        lfucache.remove(key);
        cacheMap.remove(key);
        minHeap.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return lfucache.containsKey(key);
    }

    @Override
    public void put(K key, V value) {
        if(cacheMap.size()>=capacity){
            K leastUsed = minHeap.poll();
            lfucache.remove(leastUsed);
            cacheMap.remove(leastUsed);
            minHeap.remove(leastUsed);
        }

        cacheMap.put(key, value);
        lfucache.put(key, lfucache.getOrDefault(key,0)+1);
        minHeap.offer(key);
    }

    @Override
    public void stats() {
        System.out.println("L2 cache hits: "+l2CacheHitCounter);
        System.out.println("L2 cache miss : "+l2CacheMissCounter);
        System.out.println("L2 cache data : "+cacheMap);
    }

    @Override
    public V get(K key) {
        if(lfucache.containsKey(key))
            l2CacheHitCounter++;
        else
            l2CacheMissCounter++;
        if(!cacheMap.containsKey(key))
            return null;
        minHeap.remove(key);
        lfucache.put(key, lfucache.get(key)+1);
        minHeap.offer(key);


        return cacheMap.get(key);

    }
}
