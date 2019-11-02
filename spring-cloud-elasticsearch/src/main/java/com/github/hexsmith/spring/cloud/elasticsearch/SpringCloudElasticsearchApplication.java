package com.github.hexsmith.spring.cloud.elasticsearch;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.github.hexsmith.spring.cloud.elasticsearch.model.Book;
import com.github.hexsmith.spring.cloud.elasticsearch.service.BookService;

/**
 * @author hexsmith
 */
@SpringBootApplication
public class SpringCloudElasticsearchApplication implements CommandLineRunner {

    @Resource
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudElasticsearchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        bookService.save(new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017"));
        bookService.save(new Book("1002", "Apache Lucene Basics", "Rambabu Posa", "13-MAR-2017"));
        bookService.save(new Book("1003", "Apache Solr Basics", "Rambabu Posa", "21-MAR-2017"));
        Page<Book> books = bookService.findByAuthor("Rambabu", PageRequest.of(0, 10, Sort.unsorted()));

        books.forEach(System.out::println);


    }

}
