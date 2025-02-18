package abc.demo.zipreel.dataModel;

import lombok.Data;

@Data
public class Movie {
    private String movieId;
    private String title;
    private String genre;
    private String releaseYear;
    private int rating;
}
