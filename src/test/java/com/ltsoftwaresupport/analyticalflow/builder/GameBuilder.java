package com.ltsoftwaresupport.analyticalflow.builder;

import com.ltsoftwaresupport.analyticalflow.model.Game;
import com.ltsoftwaresupport.analyticalflow.model.Platform;
import com.ltsoftwaresupport.analyticalflow.model.Publisher;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Lucas Tropardi
 * 26 de Mai. de 2024
 */
public class GameBuilder {

    private Game game;

    public static GameBuilder build() {
        byte[] imageData = new byte[]{1,2,1,2};
        Publisher publisher = new Publisher();
        GameBuilder gameBuilder = new GameBuilder();
        gameBuilder.game = new Game();
        gameBuilder.game.setId(0L);
        gameBuilder.game.setName("Super Mário Bros");
        gameBuilder.game.setReleaseDate(LocalDate.of(1985, 3, 15));
        gameBuilder.game.setWebsite("http://nintendo.com");
        gameBuilder.game.setPublisher(publisher);
        gameBuilder.game.setPlatform(new HashSet<Platform>(Collections.singleton(Platform.SWITCH)));
        gameBuilder.game.setBrief("This is the best game ever.");
        gameBuilder.game.setImage(imageData);
        return gameBuilder;
    }

    public GameBuilder addName(String name) {
        game.setName(name);
        return this;
    }

    public GameBuilder addReleaseDate(LocalDate releaseDate) {
        game.setReleaseDate(releaseDate);
        return this;
    }

    public GameBuilder addWebsite(String website) {
        game.setWebsite(website);
        return this;
    }

    public GameBuilder addPublisher(Publisher publisher) {
        game.setPublisher(publisher);
        return this;
    }

    public GameBuilder addPlatforms(Set<Platform> platforms) {
        game.setPlatform(platforms);
        return this;
    }

    public GameBuilder addImage(byte[] image) {
        game.setImage(image);
        return this;
    }

    public Game now() {
        return game;
    }
}
