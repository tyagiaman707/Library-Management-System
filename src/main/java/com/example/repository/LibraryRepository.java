package com.example.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Library;


@Repository
public class LibraryRepository {
	private Session session;
	private Transaction trans;
	public LibraryRepository(SessionFactory factory) {
		session=factory.openSession();
		trans=session.getTransaction();
	}

	public void addBook(Library book) {
		trans.begin();
		session.persist(book);
		trans.commit();
	}

	public List<Library> getBookList() {
		Query<Library> query= session.createQuery("from Library",Library.class);
		List<Library> qlist = query.list();
		return qlist;
	}

	public Library getRec(int bid) {
		Library lib = session.get(Library.class, bid);
		return lib;
	}

	public Library getBookRec(int bid) {
		Library lib= session.get(Library.class,bid);
		return lib;
	}

	public void deleteBk(Library libr) {
		trans.begin();
		session.remove(libr);
		trans.commit();
	}

	public void updateRecord(Library obook, Library book) {
		trans.begin();
		obook.setBid(book.getBid());
		obook.setBname(book.getBname());
		obook.setAuthor(book.getAuthor());
		obook.setDeckNo(book.getDeckNo());
		obook.setIssuedTo(book.getIssuedTo());
		obook.setNumber(book.getNumber());
		trans.commit();
	}

	
}
