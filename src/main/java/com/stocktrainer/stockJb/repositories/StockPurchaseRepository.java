package com.stocktrainer.stockJb.repositories;

import com.stocktrainer.stockJb.model.StockPurchase;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockPurchaseRepository extends MongoRepository<StockPurchase, String> {
    StockPurchase findBy_id(ObjectId _id);
}
