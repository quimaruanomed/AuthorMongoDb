package com.example.AuthorMongoDBH2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AuthorService {

		@Autowired
		AuthorRepository authorRepository;

		//CRUD basic operations
		public Iterable<Author> findAll() {

			return authorRepository.findAll();
		}

		public Author save(Author author) {
			authorRepository.save(author);

			return author;
		}


		public void deleteById(String id) {

			authorRepository.deleteById(id);
		}


		public long count() {
			long quantity = authorRepository.count();

			return quantity;
		}
		public Author findItemByName(String name) {



				Author authorFound = authorRepository.findItemByName(name);



			return authorFound;
		}



		public void deleteAll() {
			authorRepository.deleteAll();

		}




	}



