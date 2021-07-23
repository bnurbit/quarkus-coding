package pt.bnurbit.coding.quarkus;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/book")
public class BookResource {

    private static final List<String> books = new ArrayList<>(Arrays.asList("Java 11 - Beginner to Guru", "Quarkus Fundamentals", "Data Structures and Algorithms")) {
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (var b : this) {
                builder.append(b).append(System.lineSeparator());
            }
            return builder.toString();
        }
    };

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getBooks() {
        return books.toString();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String addBook(String book) {
        books.add(book);
        return getBooks();
    }

    @PUT
    @Path("/{index}")
    @Produces(MediaType.TEXT_PLAIN)
    public String addBook(@PathParam("index") int index, String book) {
        if (index < books.size()) {
            books.set(index, book);
        }
        return getBooks();
    }

    @DELETE
    @Path("/{index}")
    @Produces(MediaType.TEXT_PLAIN)
    public String addBook(@PathParam("index") int index) {
        if (index < books.size()) {
            books.remove(index);
        }
        return getBooks();
    }
}
