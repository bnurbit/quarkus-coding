package pt.bnurbit.coding.quarkus.book;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.panache.common.Sort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "books")
public class BookEntity extends PanacheEntity {

    // included in panache Entity
    // PanacheEntityBase can also be used alon with PanacheRepositoryBase
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Integer id;

    private String name;

    private String author;

    private Integer pages;

    public static List<BookEntity> findAllBooks(){
        return findAll().list();
    }

    public static List<BookEntity> findAllBooksSortByPages() {
        return listAll(Sort.by("pages"));
    }
}
