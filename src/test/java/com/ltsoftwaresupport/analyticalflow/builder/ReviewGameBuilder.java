package com.ltsoftwaresupport.analyticalflow.builder;

import com.ltsoftwaresupport.analyticalflow.model.Game;
import com.ltsoftwaresupport.analyticalflow.model.Platform;
import com.ltsoftwaresupport.analyticalflow.model.ReviewGame;
import com.ltsoftwaresupport.analyticalflow.model.User;

import java.time.LocalDateTime;

/**
 * @author Lucas Tropardi
 * 27 de Mai. de 2024
 */
public class ReviewGameBuilder {

    ReviewGame reviewGame;

    public static ReviewGameBuilder build() {
        ReviewGameBuilder reviewGameBuilder = new ReviewGameBuilder();
        reviewGameBuilder.reviewGame = new ReviewGame();
        reviewGameBuilder.reviewGame.setId(0L);
        reviewGameBuilder.reviewGame.setGame(new Game());
        reviewGameBuilder.reviewGame.setTitle("Great Game");
        reviewGameBuilder.reviewGame.setContent("Topzera");
        reviewGameBuilder.reviewGame.setRating(5);
        reviewGameBuilder.reviewGame.setUser(new User());
        reviewGameBuilder.reviewGame.setPlatform(Platform.PC);
        reviewGameBuilder.reviewGame.setDate(LocalDateTime.now());
        return reviewGameBuilder;
    }

    public ReviewGameBuilder addGame(Game game) {
        reviewGame.setGame(game);
        return this;
    }

    public ReviewGameBuilder addTitle(String title) {
        reviewGame.setTitle(title);
        return this;
    }

    public ReviewGameBuilder addContent(String content) {
        reviewGame.setContent(content);
        return this;
    }

    public ReviewGameBuilder addRating(int rating) {
        reviewGame.setRating(rating);
        return this;
    }

    public ReviewGameBuilder addUser(User user) {
        reviewGame.setUser(user);
        return this;
    }

    public ReviewGameBuilder addPlatform(Platform platform) {
        reviewGame.setPlatform(platform);
        return this;
    }

    public ReviewGameBuilder addDate(LocalDateTime date) {
        reviewGame.setDate(date);
        return this;
    }

    public ReviewGame now() {
        return reviewGame;
    }
}
