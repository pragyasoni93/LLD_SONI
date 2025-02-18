package abc.demo.zipreel.repo;

import abc.demo.zipreel.dataModel.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieDB {

    private static final Map<Integer, Movie> movieMap = new HashMap<>();
    private static int movieIdCounter = 1;

    public static void addMovie(Movie movie){
        if(movieMap.containsKey(movie.getMovieId()))
            System.out.println("Movie is already present");
        else {
            movieMap.put(movieIdCounter, movie);
            movieIdCounter++;
            System.out.println("Movie : " + movie.getTitle()+" added succesully");
        }
    }

    public static List<Movie> searchMovies(String key, String value){
        List<Movie> movies = new ArrayList<>();
        for(Movie movie : movieMap.values()){
            if(key.equals("title") && value.equalsIgnoreCase(movie.getTitle()) ||
                    key.equals("genre") && value.equalsIgnoreCase(movie.getGenre()) ||
                    key.equals("releaseYear") && value.equalsIgnoreCase(movie.getReleaseYear()) ||
                    key.equals("rating") && value.equals(movie.getRating())) {
                movies.add(movie);
            }
        }
        return movies;
    }
}
