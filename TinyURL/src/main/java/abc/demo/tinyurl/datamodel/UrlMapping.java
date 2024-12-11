package abc.demo.tinyurl.datamodel;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
public class UrlMapping {

    @Id
    @Column(name = "short_url", length = 8, nullable = false)
    private String shortUrl;

    @Column(name = "long_url", length = 2000, nullable = false)
    private String longUrl;

    public UrlMapping() {}

    public UrlMapping(String shortUrl, String longUrl){
        this.shortUrl =shortUrl;
        this.longUrl = longUrl;
    }
}
