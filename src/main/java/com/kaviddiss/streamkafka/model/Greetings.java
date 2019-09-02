package com.kaviddiss.streamkafka.model;

import org.springframework.data.mongodb.core.mapping.Document;

// lombok autogenerates getters, setters, toString() and a builder (see https://projectlombok.org/):
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter @ToString 
@Builder 
@Data
@NoArgsConstructor
@Document(collection = "greetings")
public class Greetings {
    private int id;
    private String message;
	public Greetings(int id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	
    
}
