package com.basic.springboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.net.URI;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Books {
    @JsonProperty("documents")
    List<Book> books;

    @JsonProperty("meta")
    Meta meta;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    class Book {
        long id;
        List<String> authors;
        String barcode;
        String category;
        String contents;

        String datetime;

        String ebook_barcode;
        String isbn;
        int price;
        String publisher;
        int sale_price;
        String sale_yn;
        String status;
        String thumbnail;
        String title;
        List<String> translators;
        URI url;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    class Meta {
        boolean isEnd;
        int pageable_count;
        int total_count;
    }
}
