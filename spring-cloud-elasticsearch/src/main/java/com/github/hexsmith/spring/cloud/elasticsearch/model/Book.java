package com.github.hexsmith.spring.cloud.elasticsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author hexsmith
 * @version v1.0
 * @since 2019-10-27 21:12
 */
@Document(indexName = "hexsmith", type = "books", shards = 1, replicas = 0)
public class Book {

    @Id
    private String id;

    private String title;

    @Field(type = FieldType.Text)
    private String author;

    private String releaseDate;

    public Book() {

    }

    public Book(String id, String title, String author, String releaseDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Book{" + "id='" + id + '\'' + ", title='" + title + '\'' + ", author='" + author + '\''
                + ", releaseDate='" + releaseDate + '\'' + '}';
    }
}
