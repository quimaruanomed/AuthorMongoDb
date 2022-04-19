package com.example.AuthorMongoDBH2;


	import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Optional;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

	@RestController
	@RequestMapping("/apiauthor")
	public class AuthorImageController {

		@Autowired
		AuthorImagesRepository authorImagesRepository;

		@PostMapping("/createAuthorImage")
		public AuthorImages createAuthorImages (@RequestParam String name, @RequestParam MultipartFile file) throws IOException  {

			AuthorImages authorImages  = new AuthorImages();
			authorImages.setName(name);
			authorImages.setImage( new Binary(file.getBytes() ));

			authorImagesRepository.save(authorImages);

			return authorImages;
		}

		@GetMapping("/getauthorImagesData")
		public String getAuthorImagesData (@RequestParam String id) {

			System.out.println("id..." + id);
			Optional<AuthorImages> authorImage = authorImagesRepository.findById(id);
			Encoder encoder = Base64.getEncoder();

			return encoder.encodeToString( authorImage.get().getImage().getData() );
		}

		@GetMapping("/getAuthorImage")
		public ResponseEntity<byte[]> getAuthorImage (@RequestParam String id) {

			Optional<AuthorImages> authorImage = authorImagesRepository.findById(id);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_JPEG);

			return new ResponseEntity<>( authorImage.get().getImage().getData(), headers, HttpStatus.OK );
		}
	}



