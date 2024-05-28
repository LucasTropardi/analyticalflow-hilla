package com.ltsoftwaresupport.analyticalflow.endpoint;

import com.ltsoftwaresupport.analyticalflow.builder.GameBuilder;
import com.ltsoftwaresupport.analyticalflow.builder.PublisherBuilder;
import com.ltsoftwaresupport.analyticalflow.builder.ReviewGameBuilder;
import com.ltsoftwaresupport.analyticalflow.builder.UserBuilder;
import com.ltsoftwaresupport.analyticalflow.exception.DefaultException;
import com.ltsoftwaresupport.analyticalflow.model.Game;
import com.ltsoftwaresupport.analyticalflow.model.Publisher;
import com.ltsoftwaresupport.analyticalflow.model.ReviewGame;
import com.ltsoftwaresupport.analyticalflow.model.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lucas Tropardi
 * 27 de Mai. de 2024
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReviewGameTest {

    @Autowired
    GameEndpoint gameEndpoint;
    @Autowired
    PublisherEndpoint publisherEndpoint;
    @Autowired
    UserEndpoint userEndpoint;
    @Autowired
    ReviewGameEndpoint endpoint;
    private Game savedGame;
    private Publisher savedPublisher;
    private User savedUser;
    private ReviewGame savedReviewGame;

    @BeforeEach
    void setup() throws DefaultException, DefaultException {
        Publisher publisher = createPublisher();
        savedPublisher = publisherEndpoint.save(publisher);
        Game game = createGame();
        game.setPublisher(savedPublisher);
        savedGame = gameEndpoint.save(game);
        User user = createUser();
        savedUser = userEndpoint.save(user);
        ReviewGame reviewGame = createReviewGame();
        reviewGame.setGame(savedGame);
        reviewGame.setUser(savedUser);
        savedReviewGame = endpoint.save(reviewGame);
    }

    @AfterEach
    void cleanup() throws DefaultException {
        if (savedReviewGame != null) {
            endpoint.delete(savedReviewGame);
        }
        if (savedUser != null) {
            userEndpoint.delete(savedUser);
        }
        if (savedGame != null) {
            gameEndpoint.delete(savedGame);
        }
        if (savedPublisher != null) {
            publisherEndpoint.delete(savedPublisher);
        }
    }

    private User createUser() {
        return UserBuilder.build().now();
    }

    private Publisher createPublisher() throws DefaultException {
        return PublisherBuilder.build().now();
    }

    private Game createGame() throws DefaultException {
        return GameBuilder.build().now();
    }

    private ReviewGame createReviewGame() {
        return ReviewGameBuilder.build().now();
    }

    @Test
    @Order(1)
    void save() throws DefaultException {
        assertNotNull(savedReviewGame);
    }

    @Test
    @Order(2)
    void update() throws DefaultException {
        assertNotNull(savedReviewGame);
        savedReviewGame.setTitle("updated");
        ReviewGame updatedReviewGame = endpoint.update(savedReviewGame);
        assertEquals("updated", updatedReviewGame.getTitle());
    }

    @Test
    @Order(3)
    void list() throws DefaultException {
        assertNotNull(endpoint.list());
    }

    @Test
    @Order(4)
    void load() throws DefaultException {
        assertNotNull(savedReviewGame);
        assertNotNull(endpoint.load(savedReviewGame.getId()));
    }

    @Test
    @Order(5)
    void delete() throws DefaultException {
        assertNotNull(savedReviewGame);
        endpoint.delete(savedReviewGame);
        assertThrows(DefaultException.class, () -> endpoint.load(savedReviewGame.getId()));
    }
}
