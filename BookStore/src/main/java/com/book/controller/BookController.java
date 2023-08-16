package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.book.entity.Book;
import com.book.entity.MyBookList;
import com.book.service.BookService;
import com.book.service.MyBookListService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private MyBookListService myBookListService;

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	
	@GetMapping("/book_register")
	public String bookRegsiter() {
		
		return "bookRegsiter";
	}
	
	@GetMapping("/available_book")
	public ModelAndView getAllBook() {
		List<Book> list=bookService.getAllBook();
		ModelAndView m=new ModelAndView();
		m.setViewName("bookList");
		m.addObject("book",list);
		return m;
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		bookService.save(b);
		return "redirect:/available_book";
	}
	
	@GetMapping("/my_book")
	public String getMyBooks(Model m) {
		List<MyBookList> list=myBookListService.getAllMyBooks();
		m.addAttribute("book", list);
		return "myBook";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b=bookService.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookListService.saveMyBooks(mb);
		return "redirect:/my_book";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model m) {
		Book b=bookService.getBookById(id);
		m.addAttribute("book", b);
		return "bookEdit";
	}
	
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		bookService.deleteById(id);
		return "redirect:/available_book";
	}
	
}
