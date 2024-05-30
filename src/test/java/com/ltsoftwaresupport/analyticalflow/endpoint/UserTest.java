package com.ltsoftwaresupport.analyticalflow.endpoint;

import com.ltsoftwaresupport.analyticalflow.builder.UserBuilder;
import com.ltsoftwaresupport.analyticalflow.exception.DefaultException;
import com.ltsoftwaresupport.analyticalflow.model.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lucas Tropardi
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTest {

    @Autowired
    UserEndpoint endPoint;

    private User savedUser;

    @BeforeEach
    void setup() throws DefaultException, DefaultException {
        User user = createUser();
        savedUser = endPoint.save(user);
    }

    @AfterEach
    void cleanup() throws DefaultException {
        if (savedUser != null) {
            endPoint.delete(savedUser);
        }
    }

    private User createUser() throws DefaultException {
        return UserBuilder.build().now();
    }

    @Test
    @Order(1)
    void save() throws DefaultException {
        assertNotNull(savedUser);
    }

    @Test
    @Order(2)
    void update() throws DefaultException {
        assertNotNull(savedUser);
        savedUser.setLastname("updated");
        User updatedUser = endPoint.update(savedUser);
        assertEquals("updated", updatedUser.getLastname());
    }

    @Test
    @Order(3)
    void list() throws DefaultException {
        assertNotNull(endPoint.list());
    }

    @Test
    @Order(4)
    void delete() throws DefaultException {
        assertNotNull(savedUser);
        endPoint.delete(savedUser);
        assertThrows(DefaultException.class, () -> endPoint.load(savedUser.getEmail()));
    }
}
