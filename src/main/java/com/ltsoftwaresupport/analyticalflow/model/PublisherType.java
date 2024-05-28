package com.ltsoftwaresupport.analyticalflow.model;

import lombok.Getter;

/**
 * @author Lucas Tropardi
 * 26 de Mai. de 2024
 */
public enum PublisherType {
    GAME("Games"),
    BOOK("Livros"),
    MOVIE("Filmes"),
    MUSIC("Músicas"),
    SERIE("Series");

    @Getter
    private String publisherType;

    PublisherType(String publisherType) {
        this.publisherType = publisherType;
    }

    @Override
    public String toString() {
        return this.publisherType;
    }
}
