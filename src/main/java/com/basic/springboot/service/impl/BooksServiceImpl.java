package com.basic.springboot.service.impl;

import com.basic.springboot.domain.Books;
import com.basic.springboot.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class BooksServiceImpl implements BooksService {
	@Autowired
	RestTemplate restTemplate;

	@Override
	public Books getBooks(String title) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "KakaoAK b213e0be9fc3047b54714796f6f0ef5e");
		HttpEntity entity = new HttpEntity(headers);

		MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<String, String>();
		queryParameters.add("query", title);

		URI uri = UriComponentsBuilder.fromHttpUrl("https://dapi.kakao.com/v2/search/book")
				.queryParams(queryParameters)
				.build().toUri();
//		Books books = restTemplate.getForObject(uri, Books.class);

		ResponseEntity<Books> bookSearchResponseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, Books.class);


		return null;
	}
}
