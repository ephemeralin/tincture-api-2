package com.ephemeralin.tincture.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import java.io.Serializable;
import java.util.logging.Logger;

@DynamoDBDocument
public class RssEntry implements Serializable {

    private static final long serialVersionUID = 101L;
    private static final Logger log = Logger.getLogger(RssEntry.class.getName());

    private String title;
    private String description;
    private String url;

    public RssEntry() {
    }

    public RssEntry(String title, String description, String url) {
        this.title = title;
        this.description = description;
        this.url = url;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return "RssEntry{" +
                "title='" + title + '\'' + ", \n" +
                "   description='" + description + '\'' + ", \n" +
                "   url='" + url + '\'' +
                '}';
    }
}