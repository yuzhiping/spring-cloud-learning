package com.github.hexsmith.spring.cloud.elasticsearch.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.github.hexsmith.spring.cloud.elasticsearch.model.Book;

/**
 * @author hexsmith
 * @version v1.0
 * @since 2019-10-27 21:16
 */
public interface BookRepository extends ElasticsearchRepository<Book, String> {

    /**
     * 根据作者名分页查询
     * 
     * @param author 作者名
     * @param pageable 分页对象
     * @return 分页书籍列表
     */
    Page<Book> findByAuthor(String author, Pageable pageable);

    /**
     * 根据标题查询
     * 
     * @param title 标题名称
     * @return 书籍列表
     */
    List<Book> findByTitle(String title);

}
