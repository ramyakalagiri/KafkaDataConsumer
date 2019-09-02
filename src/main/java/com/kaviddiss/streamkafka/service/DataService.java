package com.kaviddiss.streamkafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kaviddiss.streamkafka.model.Greetings;
import com.kaviddiss.streamkafka.repository.GenericMongoRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DataService {
	private GenericMongoRepository genericMongoRepository;
	
	@Autowired
	public DataService(GenericMongoRepository genericMongoRepository) {
		this.genericMongoRepository = genericMongoRepository;
	}
	public void saveMongoData(Greetings mongoData) {
		genericMongoRepository.save(mongoData);
	}
}