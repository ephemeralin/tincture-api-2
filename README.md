# Tincture: API

This is a REST API service (a part of backend) for the website **[Tincture](https://tincture.ephemeralin.com/)**. 
It is created as a Spring Boot web application running on AWS EC2 instance. 
The API provides endpoints to get access to news feeds from the serverless database for the frontend part of the application.

The Tincture API is created using such technologies:

* Core Java;
* Spring Boot for the easier web-development and DI for sure;
* Spring Data for creating REST endpoints;
* [AWS Elastic Beanstalk](https://aws.amazon.com/elasticbeanstalk/) for deploying web application; 
* [AWS DynamoDB](https://aws.amazon.com/dynamodb/) - serverless NoSQL database for retrieving news feeds data;
* [Let’s Encrypt](https://letsencrypt.org) for generating SSL certificates and enabling HTTPS on the website;

"Tincture" is a service which is aggregating different news feeds in one place. It is built for those who are annoyed by ads, subscriptions, "fat" web-sites, "smart" recommendations and infinite browsing between all that stuff.
