package pt.bnurbit.coding.quarkus.book;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Path("/book/entity")
public class BookEntityResource {

    @Inject
    private EntityManager entityManager;

    @Inject
    private BookRepository bookRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BookEntity> getBooks() {
        //return entityManager.createQuery("select b from books b", BookEntity.class).getResultList();
        //return BookEntity.findAllBooks();

        //final Stream<BookEntity> stream = BookEntity.streamAll();
        //stream.filter(it -> it.getName().equals("Name")).collect(Collectors.toList());

        final PanacheQuery<BookEntity> query = BookEntity.find("author", "Name");
        query.page(Page.ofSize(50));
        query.page(Page.of(2, 50));
        query.nextPage();
        query.pageCount();

        return BookEntity.listAll(Sort.by("pages"));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public BookEntity addBook(BookEntity book) {
        //entityManager.persist(book);
        book.persist();
        return book;
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public BookEntity updateBook(@PathParam("id") Long id, BookEntity book) {
        BookEntity bookEntity = BookEntity.findById(id);
        //entityManager.merge(book);
        //bookRepository.findById(id, LockModeType.PESSIMISTIC_WRITE);
        //bookRepository.find("id", id).withLock(LockModeType.PESSIMISTIC_WRITE);
        bookEntity.persist();
        return book;
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public void deleteBook(@PathParam("id") Long id) {
        //entityManager.merge(book);
        //BookEntity.delete("id", id);
        bookRepository.deleteById(id);
    }
}
