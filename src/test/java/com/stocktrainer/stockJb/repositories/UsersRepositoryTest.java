package com.stocktrainer.stockJb.repositories;

import com.stocktrainer.stockJb.ApplicationTest;
import com.stocktrainer.stockJb.fixtures.DbTestSetup;
import com.stocktrainer.stockJb.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * <h1>UsersRepositoryTest</h1
 * <p>Test class for UsersRepository</p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersRepositoryTest extends ApplicationTest {

    @Autowired
    UsersRepository testRepository;

    private String testUsername = "testUsername";
    private String testPassword = "testPassword";

    private User testUser;

    @Before
    public void initialize() {
        DbTestSetup.addTestData();
    }

    @After
    public void cleanUp() {
        DbTestSetup.clearTestData();
    }

    @Test
    public void findByReturnsUser() {
        testUser = testRepository.findByUsername(testUsername);
        assertEquals(testUser.getUsername(), testUsername);
    }

    @Test
    public void findBySetsUserId() {
        testUser = testRepository.findByUsername(testUsername);
        assertNotNull(testUser.get_id());
    }

    @Test
    public void insertAddsNewUser() {
        String insertUsername = "anotherUsername!";
        testUser = new User(insertUsername, testUsername);
        testRepository.save(testUser);
        testUser = testRepository.findByUsername(insertUsername);
        assertEquals(testUser.getUsername(), insertUsername);
    }
}
