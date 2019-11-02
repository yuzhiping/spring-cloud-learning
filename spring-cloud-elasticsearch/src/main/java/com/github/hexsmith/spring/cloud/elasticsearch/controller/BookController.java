package com.github.hexsmith.spring.cloud.elasticsearch.controller;

import javax.annotation.Resource;

import org.elasticsearch.index.query.MatchQueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.hexsmith.spring.cloud.elasticsearch.model.Book;
import com.github.hexsmith.spring.cloud.elasticsearch.service.BookService;

/**
 * @author hexsmith
 * @version v1.0
 * @since 2019-11-02 23:07
 */
@RestController
public class BookController {

    @Resource
    private BookService bookService;


    @PostMapping("/create")
    public Book create(@RequestBody Book book) {
        return bookService.save(book);
    }

    @GetMapping("/bookPage")
    public Page<Book> bookPage() {
        return bookService.findByAuthor("Rambabu", PageRequest.of(0, 10, Sort.unsorted()));
    }

    @GetMapping("/search")
    public Page<Book> search(@RequestParam(name = "key") String searchKey) {
        MatchQueryBuilder queryBuilder = new MatchQueryBuilder("author", searchKey);
        return bookService.search(queryBuilder, PageRequest.of(0, 20));
    }


}
