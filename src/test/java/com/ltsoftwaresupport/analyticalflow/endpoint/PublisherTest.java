package com.ltsoftwaresupport.analyticalflow.endpoint;

import com.ltsoftwaresupport.analyticalflow.builder.PublisherBuilder;
import com.ltsoftwaresupport.analyticalflow.exception.DefaultException;
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
public class PublisherTest {

    @Autowired
    PublisherEndpoint endpoint;
    private Publisher savedPublisher;

    @BeforeEach
    void setup() throws DefaultException, DefaultException {
        Publisher publisher = createPublisher();
        savedPublisher = endpoint.save(publisher);
    }

    @AfterEach
    void cleanup() throws DefaultException {
        if (savedPublisher != null) {
            endpoint.delete(savedPublisher);
        }
    }

    private Publisher createPublisher() throws DefaultException {
        return PublisherBuilder.build().now();
    }

    @Test
    @Order(1)
    void save() throws DefaultException {
        assertNotNull(savedPublisher);
    }

    @Test
    @Order(2)
    void update() throws DefaultException {
        assertNotNull(savedPublisher);
        savedPublisher.setWebsite("updated");
        Publisher updatedPublisher = endpoint.update(savedPublisher);
        assertEquals("updated", updatedPublisher.getWebsite());
    }

    @Test
    @Order(3)
    void list() throws DefaultException {
        assertNotNull(endpoint.list());
    }

    @Test
    @Order(4)
    void load() throws DefaultException {
        assertNotNull(savedPublisher);
        assertNotNull(endpoint.load(savedPublisher.getId()));
    }

    @Test
    @Order(5)
    void delete() throws DefaultException {
        assertNotNull(savedPublisher);
        endpoint.delete(savedPublisher);
        assertThrows(DefaultException.class, () -> endpoint.load(savedPublisher.getId()));
    }
}
