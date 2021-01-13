package com.example.lab5.project.repository;

import com.example.lab5.project.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

// allows connection to the database
@Repository
public class BookRepository {

    //spring permite tragerea directa a dependentelor
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Book> findAll() {
        List<Book> bookList = jdbcTemplate.query("SELECT * FROM book",
                (response, rowNumber) ->
                        new Book(response.getLong("id"),
                                response.getString("name"),
                                response.getString("author"),
                                response.getInt("nr_page")));
    return bookList;
    }

    public Book findById(long id) {
        Book book = jdbcTemplate.queryForObject("SELECT * FROM book WHERE id = ?",
                new Object[]{id},
                (response, rowNumber) ->
                new Book(response.getLong("id"),
                        response.getString("name"),
                        response.getString("author"),
                        response.getInt("nr_page")));
        return book;
    }

    public List<Book> findAllByNrPage(Integer nrPage) {
        List<Book> bookList = jdbcTemplate.query(
                "SELECT * FROM book WHERE nr_page = ? ",
                new Object[]{nrPage},
                (response, rowNumber) ->
                        new Book(response.getLong("id"),
                                response.getString("name"),
                                response.getString("author"),
                                response.getInt("nr_page")));
        return bookList;
    }

    public Book findByIdAndName(long id, String name) {
        Book book = jdbcTemplate.queryForObject(
                "SELECT * FROM book WHERE id = ? AND name = ?",
                new Object[]{id, name},
                (response, rowNumber) ->
                        new Book(response.getLong("id"),
                                response.getString("name"),
                                response.getString("author"),
                                response.getInt("nr_page")));
        return book;
    }

    //For @PathVariable and @RequestParam
    public void save(String name, String author, Integer nrPage ) {
        jdbcTemplate.update(
                "INSERT INTO book(name, author, nr_page) VALUES (?, ?, ?)", name, author, nrPage);
    }

    //For @RequestBody
    public void save(Book book) {
        jdbcTemplate.update(
                "INSERT INTO book(name, author, nr_page) VALUES (?, ?, ?)",
                book.getName(), book.getAuthor(), book.getNrPage());
    }

    public void update(Long id, Book book) {
        jdbcTemplate.update("UPDATE book SET name = ?, author = ?, nr_page = ? WHERE id = ?",
                book.getName(), book.getAuthor(), book.getNrPage(), id);
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM book WHERE id = ?", id);
    }

}
