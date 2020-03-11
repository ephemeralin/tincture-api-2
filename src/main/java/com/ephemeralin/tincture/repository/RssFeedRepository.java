package com.ephemeralin.tincture.repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.ephemeralin.tincture.model.FeedArea;
import com.ephemeralin.tincture.model.RssEntry;
import com.ephemeralin.tincture.model.RssFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Repository
public class RssFeedRepository {

    public static final String RSS_FEEDS_TABLE_NAME = "tin-rssFeeds-dev";
    private static final Logger log = Logger.getLogger(String.valueOf(RssFeedRepository.class));

    private final DynamoDB dynamoDB;
    private final DynamoDBMapper dynamoDBMapper;
    private final Table dbTable;

    @Autowired
    public RssFeedRepository(AmazonDynamoDB amazonDynamoDB, DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
        this.dynamoDB = new DynamoDB(amazonDynamoDB);
        this.dbTable = dynamoDB.getTable(RSS_FEEDS_TABLE_NAME);
    }

    public List<RssFeed> queryByFeedArea(FeedArea feedArea) {
        log.info("start queryByFeedArea " + feedArea.name());
        log.info("query run start");
        QuerySpec querySpec = new QuerySpec()
                .withKeyConditionExpression("feedArea = :v_area")
                .withValueMap(new ValueMap().withString(":v_area", feedArea.name()));
        log.info("query run start");
        ItemCollection<QueryOutcome> items = dbTable.query(querySpec);
        log.info("query run done");
        List<RssFeed> rssFeeds = new ArrayList<>();
        for (Item item : items) {
            RssFeed rssFeed = convertItemToRssFeed(item);
            rssFeeds.add(rssFeed);
        }
        log.info("demarshalled to RssFeeds list");
        List<RssFeed> sortedRssFeeds = rssFeeds.stream().sorted(Comparator.comparingInt(RssFeed::getFeedOrder)).collect(Collectors.toList());
        log.info("sorted RssFeeds list");
        log.info("finish queryByFeedArea " + feedArea.name());
        return sortedRssFeeds;
    }

    private RssFeed convertItemToRssFeed(Item item) {
        RssFeed rssFeed = new RssFeed();
        rssFeed.setFeedOrder(item.getInt("feedOrder"));
        rssFeed.setFeedHostUrl(item.getString("feedHostUrl"));
        rssFeed.setFeedPrettyName(item.getString("feedPrettyName"));
        rssFeed.setFeedArea(FeedArea.valueOf(item.getString("feedArea")));
        rssFeed.setFeedName(item.getString("feedName"));
        rssFeed.setFeedUpdated(item.getString("feedUpdated"));
        List<HashMap<String, String>> entries = item.getList("entries");
        ArrayList<RssEntry> rssEntries = new ArrayList<>();
        for (HashMap<String, String> entry : entries) {
            RssEntry rssEntry = new RssEntry();
            rssEntry.setDescription(entry.get("description"));
            rssEntry.setTitle(entry.get("title"));
            rssEntry.setUrl(entry.get("url"));
            rssEntries.add(rssEntry);
        }
        rssFeed.setEntries(rssEntries);
        return rssFeed;
    }
}
