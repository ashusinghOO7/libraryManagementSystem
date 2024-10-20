package com.example.libraryManagementSystem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.libraryManagementSystem.Services.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	@PostMapping("/issueBook")
	public ResponseEntity issueBook(@RequestParam(value = "cardId") int cardId,@RequestParam("bookId") int bookId) throws Exception {
		String transaction_id = transactionService.issueBooks(cardId, bookId);
		return new ResponseEntity("Your Transaction was successfull. Your Txn Id is: " + transaction_id, HttpStatus.OK);
	}
	
	@PostMapping("/returnBook")
	public ResponseEntity returnBook(@RequestParam("cardId")int cardId, @RequestParam("bookId") int bookId) throws Exception {
		String transaction_id = transactionService.returnBooks(cardId, bookId);
		return new ResponseEntity("Your Transaction was successfull. Your Txn Id is: " + transaction_id, HttpStatus.OK);
	}
}
