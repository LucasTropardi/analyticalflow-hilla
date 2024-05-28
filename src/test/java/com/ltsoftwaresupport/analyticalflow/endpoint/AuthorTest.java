package com.ltsoftwaresupport.analyticalflow.endpoint;

import com.ltsoftwaresupport.analyticalflow.builder.AuthorBuilder;
import com.ltsoftwaresupport.analyticalflow.exception.DefaultException;
import com.ltsoftwaresupport.analyticalflow.model.Author;
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
public class AuthorTest {

    @Autowired
    AuthorEndpoint endpoint;
    private Author savedAuthor;

    @BeforeEach
    void setup() throws DefaultException, DefaultException {
        Author author = createAuthor();
        savedAuthor = endpoint.save(author);
    }

    @AfterEach
    void cleanup() throws DefaultException {
        if (savedAuthor != null) {
            endpoint.delete(savedAuthor);
        }
    }

    private Author createAuthor() throws DefaultException {
        return AuthorBuilder.build().now();
    }

    @Test
    @Order(1)
    void save() throws DefaultException {
        assertNotNull(savedAuthor);
    }

    @Test
    @Order(2)
    void update() throws DefaultException {
        assertNotNull(savedAuthor);
        savedAuthor.setName("updated");
        Author updatedAuthor = endpoint.update(savedAuthor);
        assertEquals("updated", updatedAuthor.getName());
    }

    @Test
    @Order(3)
    void list() throws DefaultException {
        assertNotNull(endpoint.list());
    }

    @Test
    @Order(4)
    void load() throws DefaultException {
        assertNotNull(savedAuthor);
        assertNotNull(endpoint.load(savedAuthor.getId()));
    }

    @Test
    @Order(5)
    void delete() throws DefaultException {
        assertNotNull(savedAuthor);
        endpoint.delete(savedAuthor);
        assertThrows(DefaultException.class, () -> endpoint.load(savedAuthor.getId()));
    }
}
