package abc.demo.zipreel.service;

import abc.demo.zipreel.cache.L1Cache;
import abc.demo.zipreel.cache.L2Cache;
import abc.demo.zipreel.dataModel.Movie;
import abc.demo.zipreel.repo.MovieDB;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchService {
//    private static final Map<Integer, L1Cache<String, List<Movie>>> l1cache = new HashMap<>(5);
//    private static final L2Cache<String , List<Movie>> l2cache = new L2Cache<>(20);
//    private int totalSearches =0, l1Hits = 0, l2Hits = 0, mainDbHits = 0;
//
//    public List<Movie> search(int userId, String key, String value){
//        totalSearches++;
//        String searchKey = key + ":"+ value;
//
//        //check l1 cache
//        l1cache.putIfAbsent(userId, new L1Cache<String , List<Movie>>(5));
//        L1Cache<String , List<Movie>> usercache = l1cache.get(userId);
//
//        if(usercache.contains(searchKey)){
//            l1Hits++;
//            System.out.println("Foundin l1 cache : " +usercache.get(searchKey));
//            return usercache.get(searchKey);
//        } else if(l2cache.contains(searchKey)){
//            l2Hits++;
//            System.out.println("Foundin l2 cache : " +l2cache.get(searchKey));
//            return l2cache.get(searchKey);
//        } else{
//            List<Movie> movies = MovieDB.searchMovies(key, value);
//            if(movies.size()>0){
//                mainDbHits++;
//                usercache.put(searchKey, movies);
//                l2cache.put(searchKey, movies);
//            }
//            System.out.println("Found in main db : "+ movies);
//        }
//
//
//    }
}
