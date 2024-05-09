package com.test.api.testapi.model;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
public class Location {
    @MongoId
    private String id;
    private String user;
    private String location;
}
