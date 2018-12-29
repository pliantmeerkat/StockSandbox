package com.stocktrainer.stockJb.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * <h1>DatabaseModel</h1>
 * <p>Parent class of all application model classes utilising the mongo db</p>
 *
 * @author jackbranch
 */
abstract class DatabaseModel implements ApplicationModel{

    @Id
    ObjectId _id;

    public Object get_id() {
        return this._id;
    }
    public void setId(ObjectId _id) {
        this._id = _id;
    }

}
