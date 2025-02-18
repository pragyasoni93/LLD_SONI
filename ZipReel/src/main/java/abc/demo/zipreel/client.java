package abc.demo.zipreel;

import abc.demo.zipreel.cache.L1Cache;
import abc.demo.zipreel.cache.L2Cache;

public class client {

//    public static void main(String[] args) {
//        System.out.println("Testing LRU Cache:");
//        L1Cache<Integer, String> lruCache = new L1Cache<>(3);
//        lruCache.put(1, "A");
//        lruCache.put(2, "B");
//        lruCache.put(3, "C");
//        lruCache.stats();
//
//        lruCache.get(1); // Access 1
//        lruCache.put(4, "C"); // Removes least recently used (2)
//        lruCache.stats();
//
//        System.out.println("\nTesting LFU Cache:");
//        L2Cache<Integer, String> lfuCache = new L2Cache<>(3);
//        lfuCache.put(1, "X");
//        lfuCache.put(2, "Y");
//        lfuCache.put(3, "Z");
//        lfuCache.stats();
//
//        lfuCache.get(1);
//        lfuCache.get(1);
//        lfuCache.put(4, "X"); // Removes least frequently used (2)
//        lfuCache.stats();
//    }
}
