package com.basic.springboot.service;

import com.basic.springboot.domain.Books;
import org.springframework.stereotype.Component;

@Component
public interface BooksService {
	Books getBooks(String title);
}
