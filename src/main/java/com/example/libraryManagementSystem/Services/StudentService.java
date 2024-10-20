package com.example.libraryManagementSystem.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libraryManagementSystem.Model.Card;
import com.example.libraryManagementSystem.Model.Student;
import com.example.libraryManagementSystem.Repositories.CardRepository;
import com.example.libraryManagementSystem.Repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CardRepository cardRepository;

	@Autowired
	CardService cardService;

	public void createStudent(Student student) {
		Card card = cardService.createCard(student);
		System.out.println("The card for the student is created with the card details" + card);
	}

	public int updateStudent(Student student) {
		return studentRepository.updateStudentDetails(student);
	}

	public void deleteStudent(int id) {
		cardService.deactivate(id);
		studentRepository.deleteCustom(id);
	}
}
