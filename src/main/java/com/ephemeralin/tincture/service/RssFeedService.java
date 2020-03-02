package com.ephemeralin.tincture.service;

import com.ephemeralin.tincture.model.FeedArea;
import com.ephemeralin.tincture.model.RssFeed;

public interface RssFeedService {
    RssFeed findByFeedArea(FeedArea feedArea);
}
