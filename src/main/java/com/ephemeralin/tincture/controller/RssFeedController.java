package com.ephemeralin.tincture.controller;

import com.ephemeralin.tincture.model.FeedArea;
import com.ephemeralin.tincture.model.Greeting;
import com.ephemeralin.tincture.model.RssFeed;
import com.ephemeralin.tincture.service.RssFeedService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RssFeedController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private final RssFeedService rssFeedService;

    public RssFeedController(RssFeedService rssFeedService) {
        this.rssFeedService = rssFeedService;
    }

    @GetMapping("/greetings")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/feeds")
    public List<RssFeed> getRssFeedByFeedArea(@RequestParam (value = "feedArea", defaultValue = "") String feedAreaString) {
        try {
            RssFeed rssFeed = rssFeedService.findByFeedArea(FeedArea.valueOf(feedAreaString));
            ArrayList<RssFeed> rssFeeds = new ArrayList<>();
            rssFeeds.add(rssFeed);
            return rssFeeds;
        } catch (Exception ex) {
            return null;
        }
    }
}
