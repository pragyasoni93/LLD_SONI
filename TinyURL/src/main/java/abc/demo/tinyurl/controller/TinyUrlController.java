package abc.demo.tinyurl.controller;

import abc.demo.tinyurl.service.TinyUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("v1/")
public class TinyUrlController {
    private TinyUrlService tinyUrlService;

    @Autowired
    public TinyUrlController(TinyUrlService tinyUrlService){
        this.tinyUrlService = tinyUrlService;
    }

    @PostMapping("tinyLink")
    public String shortenUrl(@RequestBody String longUrl){
        return tinyUrlService.shortenUrl(longUrl);
    }

    @GetMapping("shortUrl")
    public RedirectView redirectShortUrl(@PathVariable String shortUrl){
        String longUrl = tinyUrlService.getOriginalUrl(shortUrl);
        if(longUrl!=null){
            return new RedirectView(longUrl);
        }else {
            return new RedirectView("www.google.com");
        }
    }
}
