package com.ephemeralin.tincture.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class RssFeedRepository {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    public RssFeedRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }
}
