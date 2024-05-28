package com.ltsoftwaresupport.analyticalflow.builder;

import com.ltsoftwaresupport.analyticalflow.model.Publisher;
import com.ltsoftwaresupport.analyticalflow.model.PublisherType;

/**
 * @author Lucas Tropardi
 * 26 de Mai. de 2024
 */
public class PublisherBuilder {

    private Publisher publisher;

    public static PublisherBuilder build() {
        PublisherBuilder publisherBuilder = new PublisherBuilder();
        publisherBuilder.publisher = new Publisher();
        publisherBuilder.publisher.setId(0L);
        publisherBuilder.publisher.setName("Publisher Name");
        publisherBuilder.publisher.setWebsite("http://google.com");
        publisherBuilder.publisher.setType(PublisherType.MOVIE);
        return publisherBuilder;
    }

    public PublisherBuilder addName(String name) {
        publisher.setName(name);
        return this;
    }

    public PublisherBuilder addWebsite(String website) {
        publisher.setWebsite(website);
        return this;
    }

    public PublisherBuilder addType(PublisherType type) {
        publisher.setType(type);
        return this;
    }

    public Publisher now() {
        return publisher;
    }
}
