package com.example.libraryManagementSystem.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.libraryManagementSystem.Model.Book;
import com.example.libraryManagementSystem.Services.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	@PostMapping("/createBook")
	public ResponseEntity createBook(@RequestBody Book book) {
		bookService.createBook(book);
		return new ResponseEntity("Book Added to the library System", HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getBooks")
	public ResponseEntity getBooks(@RequestParam(value = "genre", required = false) String genre,@RequestParam(value = "available", required = false, defaultValue = "false") boolean available,@RequestParam(value = "author", required = false) String author){		
	List<Book> bookList = bookService.getBooks(genre, available, author);
				return new ResponseEntity(bookList,HttpStatus.OK);
		
	}
}
