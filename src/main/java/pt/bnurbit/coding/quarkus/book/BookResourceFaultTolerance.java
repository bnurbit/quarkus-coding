package pt.bnurbit.coding.quarkus.book;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Path("/book/fault-tolerance")
@Slf4j
public class BookResourceFaultTolerance {

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
    @Path("/retry")
    @Produces(MediaType.APPLICATION_JSON)
    @Retry(maxRetries = 5, delay = 1000L)
    public Response getBooksRetry() {
        final boolean fail = new Random().nextBoolean();
        if(fail) {
            log.info("Retry: Failed to retrieve data");
            throw new RuntimeException("Failed to retrieve data");
        }
        return Response.ok(books).build();
    }

    @GET
    @Path("/timeout")
    @Produces(MediaType.APPLICATION_JSON)
    @Timeout()
    public Response getBooksTimeout() throws InterruptedException {
        final boolean fail = new Random().nextBoolean();
        if(fail) {
            log.info("Timeout: Failed to retrieve data");
            Thread.sleep(2000L);
        }
        return Response.ok(books).build();
    }

    @GET
    @Path("/fallback")
    @Produces(MediaType.APPLICATION_JSON)
    @Fallback(fallbackMethod = "getFallBackBooks")
    public Response getBooksFallback() {
        final boolean fail = new Random().nextBoolean();
        if(fail) {
            log.info("Fallback: Failed to retrieve data. Returning fallback data.");
            throw new RuntimeException("Failed to retrieve data");
        }
        return Response.ok(books).build();
    }

    private Response getFallBackBooks() {
        return Response.ok(List.of(new Book("Fallback book", "Author", 5))).build();
    }

    @GET
    @Path("/circuit-breaker")
    @Produces(MediaType.APPLICATION_JSON)
    @CircuitBreaker(failureRatio = 0.3, requestVolumeThreshold = 3, failOn = RuntimeException.class, delay = 20000L)
    public Response getBooksCircuitBreaker() {
        final boolean fail = new Random().nextBoolean();
        if(fail) {
            log.info("CircuitBreaker: Failed to retrieve data. Returning fallback data.");
            throw new RuntimeException("Failed to retrieve data");
        }
        return Response.ok(books).build();
    }
}
