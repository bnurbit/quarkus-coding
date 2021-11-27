package pt.bnurbit.coding.quarkus.book;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/book/entity")
public class BookEntityResource {

    @Inject
    private EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BookEntity> getBooks() {
        return entityManager.createQuery("select b from books b", BookEntity.class).getResultList();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public BookEntity addBook(BookEntity book) {
        entityManager.persist(book);
        return book;
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public BookEntity updateBook(@PathParam("id") Integer id, BookEntity book) {
        entityManager.merge(book);
        return book;
    }
}
