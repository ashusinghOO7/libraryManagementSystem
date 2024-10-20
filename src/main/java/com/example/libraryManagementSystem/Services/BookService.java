package com.example.libraryManagementSystem.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libraryManagementSystem.Model.Book;
import com.example.libraryManagementSystem.Repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	public void createBook(Book book) {
		bookRepository.save(book);
	}

	public List<Book> getBooks(String genre, boolean isAvailable, String author) {
		if (genre != null && author != null) {
			return bookRepository.findBooksByGenre_Author(genre, author, isAvailable);
		} else if (genre != null) {
			return bookRepository.findBooksByGenre(genre, isAvailable);
		} else if (author != null) {
			return bookRepository.findBooksByAuthor(author, isAvailable);
		}
		return bookRepository.findBookByAvailability(isAvailable);
	}
}
