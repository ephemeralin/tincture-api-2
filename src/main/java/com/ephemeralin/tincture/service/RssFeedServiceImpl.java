package com.ephemeralin.tincture.service;

import com.ephemeralin.tincture.model.FeedArea;
import com.ephemeralin.tincture.model.RssFeed;
import com.ephemeralin.tincture.repository.RssFeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("RssFeedService")
public class RssFeedServiceImpl implements RssFeedService {

    private final RssFeedRepository rssFeedRepository;

    @Autowired
    public RssFeedServiceImpl(RssFeedRepository rssFeedRepository) {
        this.rssFeedRepository = rssFeedRepository;
    }

    @Override
    public List<RssFeed> findByFeedArea(FeedArea feedArea) {
        return rssFeedRepository.queryByFeedArea(feedArea);
    }
}
