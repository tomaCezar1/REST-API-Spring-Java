package com.example.lab5.project.controllers;

import com.example.lab5.project.entity.Book;
import com.example.lab5.project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    // link between the REST API and the repository
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> findAll() {
        final List<Book> bookList = bookRepository.findAll();
        return bookList;
    }

    @GetMapping("/nrPage/{nrPage}")
    public List<Book> findAllByNrPage(@PathVariable Integer nrPage) {
        List<Book> bookList = bookRepository.findAllByNrPage(nrPage);
        return bookList;
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable long id) {
        Book book = bookRepository.findById(id);
        return book;
    }

    @GetMapping("/{id}/{name}")
    public Book findByIdAndName(@PathVariable long id, @PathVariable String name) {
        Book book = bookRepository.findByIdAndName(id, name);
        return book;
    }

    // @PathVariable
//    @PostMapping("/{name}/{author}/{nrPage}")
//    public void save(@PathVariable String name, @PathVariable String author, @PathVariable Integer nrPage){
//        bookRepository.save(name, author, nrPage);
//    }

    //@RequestParam
//    @PostMapping
//    public void save(@RequestParam("Nume") String name, @RequestParam(required = false) String author, @RequestParam Integer nrPage){
//        bookRepository.save(name, author, nrPage);
//    }

    @PostMapping
    public void save(@RequestBody Book book){
        bookRepository.save(book);
    }


    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Book book) {
        bookRepository.update(id, book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookRepository.delete(id);
    }
}
