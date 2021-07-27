package pt.bnurbit.coding.quarkus;

import pt.bnurbit.coding.quarkus.data.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/book/json")
public class BookResourceJson {

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
        books.add(new Book("Java 11 - Beginner to Guru", "Author1"));
        books.add(new Book("Quarkus Fundamentals", "Author2"));
        books.add(new Book("Data Structures and Algorithms", "Author3"));
    }

    @GET
    public Response getBooks() {
        return Response.ok(books).build();
    }

    @POST
    public Response addBook(Book book) {
        if(books.size() >= 5){
            return Response.status(400).entity("Maximum number of books reached!").build();
        }
        books.add(book);
        return getBooks();
    }

    @PUT
    @Path("/{index}")
    public Response addBook(@PathParam("index") int index, Book book) {
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
