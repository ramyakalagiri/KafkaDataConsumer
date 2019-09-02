package com.kaviddiss.streamkafka.listener;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.kaviddiss.streamkafka.model.Greetings;
import com.kaviddiss.streamkafka.service.DataService;

//import com.kaviddiss.streamkafka.stream.GreetingsStreams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.messaging.Sink;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
@Slf4j
public class GreetingsListener {
	@Autowired
	private DataService getDataFromMongo;
    @StreamListener(Sink.INPUT)
    public void handleGreetings(@Payload String greetings) {
        log.info("Received greetings: {}", greetings);
        XmlMapper xmlMapper = new XmlMapper();
        try {
			Greetings greetingsResult = xmlMapper.readValue(greetings, Greetings.class);
			
			System.out.println(greetingsResult);
			getDataFromMongo.saveMongoData(greetingsResult);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
