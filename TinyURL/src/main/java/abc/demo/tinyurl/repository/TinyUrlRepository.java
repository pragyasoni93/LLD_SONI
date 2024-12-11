package abc.demo.tinyurl.repository;

import abc.demo.tinyurl.datamodel.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TinyUrlRepository extends JpaRepository<UrlMapping, String> {
    Optional<UrlMapping> findByShortUrl(String shortUrl);
}
