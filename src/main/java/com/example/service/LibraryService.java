package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Library;
import com.example.repository.LibraryRepository;

@Service
public class LibraryService {
	@Autowired
	private LibraryRepository repo;

	public void save(Library book) {
		repo.addBook(book);
	}

	public List<Library> getList() {
		return repo.getBookList();
	}

	public Library getRecord(int bid) {
		return repo.getRec(bid);
	}

	public Library getBook(int bid) {
		return repo.getBookRec(bid);
	}

	public void deleteBook(int bid) {
		Library libr = repo.getRec(bid);
		repo.deleteBk(libr);
	}

	public void updateRec(Library book) {
		Library obook = repo.getRec(book.getBid());
		repo.updateRecord(obook,book);
	}

	
}
