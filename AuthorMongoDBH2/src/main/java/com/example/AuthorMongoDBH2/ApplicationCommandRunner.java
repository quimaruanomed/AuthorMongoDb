package com.example.AuthorMongoDBH2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;


@Component
@EnableMongoRepositories
public class ApplicationCommandRunner implements CommandLineRunner {

	protected final Log logger = LogFactory.getLog(getClass());


	@Autowired
	AuthorService authorService;


	@Override
	public void run(String... args) throws Exception {

		logger.info("Welcome to the runner from commandLineRunner to test JPA mapping 1:n");
        authorService.deleteAll();
		authorService.save(new Author("Paulo Coelho","Rio de Janeiro", 1947, 023, false));
		authorService.save(new Author("Isabel Allende", "Lima", 1942, 143, false));
		authorService.save(new Author("Stephen King","Portland", 1947, 204, false));
        logger.info("Data creation Employee complete...");

        Iterable<Author> employees = authorService.findAll();
        logger.info("Data Employee query get " + employees);
        logger.info("employees count: " + authorService.count());


        authorService.save(new Author("Miguel Delibes","Valladolid", 1920, 150, false));


	}

}



