package pt.bnurbit.coding.quarkus.book;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class BookRepository implements PanacheRepository<BookEntity> {

    public List<BookEntity> findAllByName(String name){
        return find("name", name).list();
    }
}
