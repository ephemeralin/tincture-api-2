package com.ephemeralin.tincture.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;

import java.io.Serializable;
import java.util.List;

@DynamoDBTable(tableName = "RSS_FEEDS_TABLE_NAME")
public class RssFeed implements Serializable {

    private static final long serialVersionUID = 100L;

    private String feedName;
    private FeedArea feedArea;
    private String feedPrettyName;
    private String feedHostUrl;
    private int feedOrder;
    private List<RssEntry> entries;
    private String feedUpdated;

    @DynamoDBRangeKey
    public String getFeedName() {
        return feedName;
    }

    public void setFeedName(String feedName) {
        this.feedName = feedName;
    }

    @DynamoDBHashKey
    @DynamoDBTypeConvertedEnum
    public FeedArea getFeedArea() {
        return feedArea;
    }

    public void setFeedArea(FeedArea feedArea) {
        this.feedArea = feedArea;
    }

    public String getFeedPrettyName() {
        return feedPrettyName;
    }

    public void setFeedPrettyName(String feedPrettyName) {
        this.feedPrettyName = feedPrettyName;
    }

    public String getFeedHostUrl() {
        return feedHostUrl;
    }

    public void setFeedHostUrl(String feedHostUrl) {
        this.feedHostUrl = feedHostUrl;
    }

    public int getFeedOrder() {
        return feedOrder;
    }

    public void setFeedOrder(int feedOrder) {
        this.feedOrder = feedOrder;
    }

    public List<RssEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<RssEntry> entries) {
        this.entries = entries;
    }

    public String getFeedUpdated() {
        return feedUpdated;
    }

    public void setFeedUpdated(String feedUpdated) {
        this.feedUpdated = feedUpdated;
    }

    @Override
    public String toString() {
        return "RssFeed{" +
                "name='" + feedName + '\'' +
                "updated ='" + feedUpdated + '\'' +
                "area ='" + feedArea + '\'' +
                ", entries n.=" + entries.size() +
                '}';
    }
}
