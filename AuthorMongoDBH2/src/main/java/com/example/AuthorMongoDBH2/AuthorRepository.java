package com.example.AuthorMongoDBH2;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface AuthorRepository extends MongoRepository<Author, String> {
	 @Query("{name:'?0'}")
	    Author findItemByName(String name);

}
