package com.example.libraryManagementSystem.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libraryManagementSystem.Model.Card;
import com.example.libraryManagementSystem.Model.CardStatus;
import com.example.libraryManagementSystem.Model.Student;
import com.example.libraryManagementSystem.Repositories.CardRepository;

@Service
public class CardService {
	
	@Autowired
	CardRepository cardRepository;
	
	public Card createCard(Student student) {
		Card card = new Card();
		student.setCard(card);
		card.setStudent(student);
		cardRepository.save(card);
		return card;
	}
	
	public void deactivate(int student_id) {
		cardRepository.deactivateCard(student_id, CardStatus.DEACTIVATED.toString());
	}

}
