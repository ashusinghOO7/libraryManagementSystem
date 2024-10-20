package com.example.libraryManagementSystem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.libraryManagementSystem.Model.Author;
import com.example.libraryManagementSystem.Services.AuthorService;

@RestController
public class AuthorController {
	
	@Autowired
	AuthorService authorService;
	
	@PostMapping("/createAuthor")
	public ResponseEntity createAuthor(@RequestBody Author author) {
		authorService.createAuthor(author);
		return new ResponseEntity("Author Created", HttpStatus.CREATED);
	}
	
	@PostMapping("/updateAuthor")
	public ResponseEntity updateAuthor(@RequestBody Author author) {
		authorService.updateAuthor(author);
		return new ResponseEntity("Author updated", HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteAuthor")
	public ResponseEntity deleteAuthor(@RequestParam("id") int id) {
		authorService.deleteAuthor(id);
		return new ResponseEntity("Author Deleted!!", HttpStatus.ACCEPTED);
	}
	
}
