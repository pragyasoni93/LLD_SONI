package abc.demo.tinyurl.service;

import abc.demo.tinyurl.datamodel.UrlMapping;
import abc.demo.tinyurl.repository.TinyUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

@Service
public class TinyUrlService {

    private TinyUrlRepository tinyUrlRepository;

    @Autowired
    public TinyUrlService(TinyUrlRepository tinyUrlRepository) {
        this.tinyUrlRepository = tinyUrlRepository;
    }

    public String shortenUrl(String longUrl) {
        Random random = new Random();
        long randomNUmber = Math.abs(random.nextLong());
        byte[] byteString = Long.toUnsignedString(randomNUmber).getBytes();

        String base64Encoder = Base64.getEncoder().encodeToString(byteString);
        String shortUrl = base64Encoder.substring(0, 8);
        tinyUrlRepository.save(new UrlMapping(shortUrl, longUrl));
        return shortUrl;
    }

    public UrlMapping getOriginalUrl(String shortUrl) {
        Optional<UrlMapping> urlMapping = tinyUrlRepository.findByShortUrl(shortUrl);
        return urlMapping.orElseThrow(() -> new NoSuchElementException("Short URL not found"));
    }
}
