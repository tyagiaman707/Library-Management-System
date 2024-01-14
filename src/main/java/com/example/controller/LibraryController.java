package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Library;
import com.example.service.LibraryService;

@Controller
@RequestMapping("library-management")
public class LibraryController {
	@Autowired
	private LibraryService service;
	@RequestMapping("")
	public String getHomeView() {
		return "home";
	}
	@RequestMapping("add")
	public String getAddView() {
		return "add-book";
	}
	@RequestMapping("save-record")
	public String saveBook(Library book) {
		service.save(book);
		return "save";
	}
	@RequestMapping("list")
	public String getListView(Model model) {
		List<Library> blist= service.getList();
		model.addAttribute("booklist", blist);
		return "book-list";
	}
	@RequestMapping("search")
	public String getSearchView() {
		return "search-book";
	}
	@RequestMapping("search-record")
	public String getSearchBook(int bid,Model model) {
		Library book = service.getRecord(bid);
		if(book==null) {
			model.addAttribute("bid", bid);
			model.addAttribute("msg","Book not found");
			return "search-book";
		}
		model.addAttribute("book", book);
		return "show-book";
	}
	@RequestMapping("delete")
	public String getDeleteView() {
		return "delete-book";
	}
	@RequestMapping("confirm-delete")
	public String deleteBookView(int bid,Model model) {
		Library book = service.getBook(bid);
		if(book==null) {
			model.addAttribute("bid", bid);
			model.addAttribute("msg","Book not found");
			return "delete-book";
		}
		model.addAttribute("book", book);
		return "confirm-delete";
	}
	@RequestMapping("delete-books")
	public String getViewDelete(int bid) {
		service.deleteBook(bid);
		return "delete";
	}
	@RequestMapping("edit")
	public String getEditView() {
		return "edit-book";
	}
	@RequestMapping("get-record")
	public String getRecordView(int bid,Model model) {
		Library book = service.getBook(bid);
		if(book==null) {
			model.addAttribute("bid", bid);
			model.addAttribute("msg","Book not found!!");
			return "edit-book";
		}
		model.addAttribute("book", book);
		return "update-book";
	}
	@RequestMapping("update-record")
	public String getUpdate(Library book) {
		service.updateRec(book);
		return "update";
	}
}
