package com.stocktrainer.stockJb.repositories;

import com.stocktrainer.stockJb.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * <h1>UsersRepository</h1>
 * <p>Responsible for managing users collection in db</p>
 */
@Repository("UsersRepository")
public interface UsersRepository extends MongoRepository<User, String> {
    User findBy_id(ObjectId _id);
    User findByUsername(String username);
}
