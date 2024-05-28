package com.ltsoftwaresupport.analyticalflow.endpoint;

import com.ltsoftwaresupport.analyticalflow.builder.AuthorBuilder;
import com.ltsoftwaresupport.analyticalflow.builder.GameBuilder;
import com.ltsoftwaresupport.analyticalflow.builder.PublisherBuilder;
import com.ltsoftwaresupport.analyticalflow.exception.DefaultException;
import com.ltsoftwaresupport.analyticalflow.model.Author;
import com.ltsoftwaresupport.analyticalflow.model.Game;
import com.ltsoftwaresupport.analyticalflow.model.Publisher;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lucas Tropardi
 * 26 de Mai. de 2024
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GameTest {

    @Autowired
    GameEndpoint endpoint;
    @Autowired
    PublisherEndpoint publisherEndpoint;
    private Game savedGame;
    private Publisher savedPublisher;

    @BeforeEach
    void setup() throws DefaultException, DefaultException {
        Publisher publisher = createPublisher();
        savedPublisher = publisherEndpoint.save(publisher);
        Game game = createGame();
        game.setPublisher(savedPublisher);
        savedGame = endpoint.save(game);
    }

    @AfterEach
    void cleanup() throws DefaultException {
        if (savedGame != null) {
            endpoint.delete(savedGame);
        }
        if (savedPublisher != null) {
            publisherEndpoint.delete(savedPublisher);
        }
    }

    private Publisher createPublisher() throws DefaultException {
        return PublisherBuilder.build().now();
    }

    private Game createGame() throws DefaultException {
        return GameBuilder.build().now();
    }

    @Test
    @Order(1)
    void save() throws DefaultException {
        assertNotNull(savedGame);
    }

    @Test
    @Order(2)
    void update() throws DefaultException {
        assertNotNull(savedGame);
        savedGame.setName("updated");
        Game updatedGame = endpoint.update(savedGame);
        assertEquals("updated", updatedGame.getName());
    }

    @Test
    @Order(3)
    void list() throws DefaultException {
        assertNotNull(endpoint.list());
    }

    @Test
    @Order(4)
    void load() throws DefaultException {
        assertNotNull(savedGame);
        assertNotNull(endpoint.load(savedGame.getId()));
    }

    @Test
    @Order(5)
    void delete() throws DefaultException {
        assertNotNull(savedGame);
        endpoint.delete(savedGame);
        assertThrows(DefaultException.class, () -> endpoint.load(savedGame.getId()));
    }
}
