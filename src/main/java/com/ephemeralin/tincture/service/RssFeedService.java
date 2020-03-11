package com.ephemeralin.tincture.service;

import com.ephemeralin.tincture.model.FeedArea;
import com.ephemeralin.tincture.model.RssFeed;

import java.util.List;

public interface RssFeedService {

    List<RssFeed> findByFeedArea(FeedArea feedArea);
}
