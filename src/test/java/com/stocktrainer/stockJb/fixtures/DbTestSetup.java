package com.stocktrainer.stockJb.fixtures;

import com.stocktrainer.stockJb.model.User;
import com.stocktrainer.stockJb.repositories.UsersRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * <h1>DbTestSetup</h1>
 * <p>Class used to setup db test data</p>
 */
public class DbTestSetup {

    /**
     * <h2>addTestData</h2>
     * <p>Function to add test data to db</p>
     */
    public static void addTestData(UsersRepository usersRepository) {
        testUserList().forEach(user ->
            usersRepository.save(user)
        );
    }

    public static void clearTestData(UsersRepository usersRepository) {
        usersRepository.deleteAll();
    }

    private static ArrayList<User> testUserList() {
        ArrayList<User> userList = new ArrayList<>();
        User setIdUser = new User("testUser2", "testPassword2");
        setIdUser.setId(new ObjectId("5349b4ddd2781d08c09890f3"));
        userList.add(new User("testUser1", "testUser1"));
        userList.add(setIdUser);
        return userList;
    }

}
