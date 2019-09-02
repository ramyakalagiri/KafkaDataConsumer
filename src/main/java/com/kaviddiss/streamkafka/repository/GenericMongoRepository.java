package com.kaviddiss.streamkafka.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kaviddiss.streamkafka.model.Greetings;

public interface GenericMongoRepository extends MongoRepository<Greetings, String>{

	
}