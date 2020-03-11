package com.ephemeralin.tincture.service;

import com.ephemeralin.tincture.model.FeedArea;
import com.ephemeralin.tincture.model.RssEntry;
import com.ephemeralin.tincture.model.RssFeed;
import com.ephemeralin.tincture.repository.RssFeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
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

//        if (feedArea != FeedArea.dev) {
//            return null;
//        }
//        List<RssEntry> rssEntries = Collections.singletonList(
//                new RssEntry("Яндекс.Диск запретил использование open source утилиты rclone",
//                        "Предыстория\n" +
//                                "\n" +
//                                "Привет, Хабр!\n" +
//                                "\n" +
//                                "\n" +
//                                "К написанию этого поста привела довольно странная ошибка, которую вчера вечером на ноутбуке с Linux (да, я из тех странных людей, кто использует GNU/Linux на ноутбуке) я получил вместо содержимого своего Яндекс.Диска:\n" +
//                                "\n" +
//                                "\n" +
//                                "$ ls -l /mnt/yadisk\n" +
//                                "ls: reading directory '.': Input/output error\n" +
//                                "total 0",
//                        "https://habr.com/ru/post/489492/?utm_source=habrahabr&utm_medium=rss&utm_campaign=489492"));
//        RssFeed rssFeed = new RssFeed();
//        rssFeed.setFeedArea(FeedArea.dev);
//        rssFeed.setEntries(rssEntries);
//        rssFeed.setFeedHostUrl("https://habr.com/");
//        rssFeed.setFeedName("habr");
//        rssFeed.setFeedPrettyName("Habr");
//        rssFeed.setFeedUpdated("2020-03-01T14:51:35.269Z[UTC]");
//        rssFeed.setFeedOrder(0);
//        return rssFeed;
    }
}
