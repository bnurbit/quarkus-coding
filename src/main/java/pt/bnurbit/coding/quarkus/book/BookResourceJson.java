package pt.bnurbit.coding.quarkus.book;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Path("/book/json")
public class BookResourceJson {

    @Inject
    private Validator validator;

    @Inject
    private BookService bookService;

    private static final List<Book> books = new ArrayList<>() {
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (var b : this) {
                builder.append(b.getName()).append(", ").append(b.getAuthor()).append(System.lineSeparator());
            }
            return builder.toString();
        }
    };

    static {
        books.add(new Book("Java 11 - Beginner to Guru", "Author1", 10));
        books.add(new Book("Quarkus Fundamentals", "Author2", 50));
        books.add(new Book("Data Structures and Algorithms", "Author3", 30));
    }

    @GET
    public Response getBooks() {
        return Response.ok(books).build();
    }

    @POST
    public Response addBook(@Valid Book book) {

        if(books.size() >= 5){
            return Response.status(400).entity("Maximum number of books reached!").build();
        }
        books.add(book);
        return getBooks();
    }

    // For REST validation, 3 options are available
    // - use @Valid in the resource object
    // - inject the validator
    // - use @Valid outside the resource object
    @POST
    @Path("/validator")
    public Response addBookValidator(Book book) {

        // alternative option 1
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        if(!violations.isEmpty()) {
            return Response.status(400).build();
        }

        // alternative option 2
        bookService.checkBook(book);

        books.add(book);
        return getBooks();
    }

    @PUT
    @Path("/{index}")
    public Response addBook(@PathParam("index") int index, @Valid Book book) {
        if (index < books.size()) {
            books.set(index, book);
        }
        return getBooks();
    }

    @DELETE
    @Path("/{index}")
    public Response addBook(@PathParam("index") int index) {
        if (index < books.size()) {
            books.remove(index);
        }
        return getBooks();
    }
}
