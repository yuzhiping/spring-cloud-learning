package com.github.hexsmith.spring.cloud.elasticsearch.service.impl;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.github.hexsmith.spring.cloud.elasticsearch.model.Book;
import com.github.hexsmith.spring.cloud.elasticsearch.repository.BookRepository;
import com.github.hexsmith.spring.cloud.elasticsearch.service.BookService;

/**
 * @author hexsmith
 * @version v1.0
 * @since 2019-10-27 22:47
 */
@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * 新增
     *
     * @param book 书籍对象
     * @return 书籍
     */
    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    /**
     * 删除
     *
     * @param book 书籍对象
     */
    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    /**
     * 根据ID查询
     *
     * @param id 书籍ID
     * @return 书籍信息
     */
    @Override
    public Book findOne(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    /**
     * 查询所有书籍
     *
     * @return
     */
    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    /**
     * 根据作者分页查询
     *
     * @param author 作者名
     * @param pageRequest 分页查询对象
     * @return 书籍信息
     */
    @Override
    public Page<Book> findByAuthor(String author, PageRequest pageRequest) {
        return bookRepository.findByAuthor(author, pageRequest);
    }

    /**
     * 根据标题查询
     *
     * @param title 标题
     * @return 书籍列表
     */
    @Override
    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    /**
     * 搜索
     *
     * @param queryBuilder 搜索条件
     * @param pageRequest 分页条件
     * @return 书籍列表
     */
    @Override
    public Page<Book> search(QueryBuilder queryBuilder, PageRequest pageRequest) {
        return bookRepository.search(queryBuilder, pageRequest);
    }
}
