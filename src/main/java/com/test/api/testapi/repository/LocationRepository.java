package com.test.api.testapi.repository;
import com.test.api.testapi.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LocationRepository extends MongoRepository<Location,String> {
    //will find all locations by user and then returns list. spring implements for us
    public List<Location> findByUser(String user);
}
