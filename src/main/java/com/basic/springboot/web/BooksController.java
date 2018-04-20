package com.basic.springboot.web;

import com.basic.springboot.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BooksController {
	
	@Autowired
	BooksService booksService;

	@GetMapping("/{title}")
	@ResponseBody
	public void getBooks(@PathVariable String title) {
		booksService.getBooks(title);
	}

}
