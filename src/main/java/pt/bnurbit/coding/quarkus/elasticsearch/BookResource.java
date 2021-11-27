package pt.bnurbit.coding.quarkus.elasticsearch;

import io.quarkus.runtime.StartupEvent;
import org.hibernate.search.mapper.orm.Search;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/book/search")
public class BookResource {

    @Inject
    private EntityManager entityManager;

    public void onStart(@Observes StartupEvent startupEvent) throws InterruptedException {
        if(BookEntity.count() > 0) {
            Search.session(entityManager)
                  .massIndexer()
                  .startAndWait();
        }
    }

    @Path("/author")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AuthorEntity> searchAuthors(@QueryParam("pattern") String pattern,
                                            @QueryParam("size")Optional<Integer> size) {
        return Search.session(entityManager)
                     .search(AuthorEntity.class)
                     .selectEntity()
                     .where(p -> pattern == null || pattern.trim().isEmpty()
                        ? p.matchAll() : p.simpleQueryString().fields("firstName", "lastName", "books.title")
                           .matching(pattern))
                     //.sort(s -> s.field("firstName_sort").then().field("lastName_sort"))
                    //.fetchHits(size.orElse(20))
                    .fetchAll()
                    .hits();

    }
}
