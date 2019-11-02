package com.github.hexsmith.spring.cloud.elasticsearch.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;

import com.github.hexsmith.spring.cloud.elasticsearch.model.Book;

/**
 * @author hexsmith
 * @version v1.0
 * @since 2019-10-27 22:43
 */
public interface BookService {

    /**
     * 新增
     * 
     * @param book 书籍对象
     * @return 书籍
     */
    Book save(Book book);

    /**
     * 删除
     * 
     * @param book 书籍对象
     */
    void delete(Book book);

    /**
     * 根据ID查询
     * 
     * @param id 书籍ID
     * @return 书籍信息
     */
    Book findOne(String id);

    /**
     * 查询所有书籍
     * 
     * @return
     */
    Iterable<Book> findAll();

    /**
     * 根据作者分页查询
     * 
     * @param author 作者名
     * @param pageRequest 分页查询对象
     * @return 书籍信息
     */
    Page<Book> findByAuthor(String author, PageRequest pageRequest);

    /**
     * 根据标题查询
     * 
     * @param title 标题
     * @return 书籍列表
     */
    List<Book> findByTitle(String title);

    /**
     * 搜索
     * 
     * @param queryBuilder 搜索条件
     * @param pageRequest 分页条件
     * @return 书籍列表
     */
    Page<Book> search(NativeSearchQuery queryBuilder, PageRequest pageRequest);

}
