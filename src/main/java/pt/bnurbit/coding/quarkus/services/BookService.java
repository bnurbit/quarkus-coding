package pt.bnurbit.coding.quarkus.services;

import pt.bnurbit.coding.quarkus.data.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;

@ApplicationScoped
public class BookService {

    public Book checkBook(@Valid Book book){

        // validation logic
        return book;
    }
}
