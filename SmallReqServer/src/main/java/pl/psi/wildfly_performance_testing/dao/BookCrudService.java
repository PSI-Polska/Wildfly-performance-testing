package pl.psi.wildfly_performance_testing.dao;

import pl.psi.wildfly_performance_testing.model.small.Address;
import pl.psi.wildfly_performance_testing.model.small.Author;
import pl.psi.wildfly_performance_testing.model.small.Book;

import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by mblaszyk on 2016-07-05.
 */

@Singleton
public class BookCrudService{
    @Inject
    EntityManager entityManager;

    @Inject
    GenericDaoIf<Book> dao;



    public void create(Book entity) {
        dao.create(entity);
    }


    public void remove(Book entity) {
        dao.remove(entity);
    }


    public void update(Book entity) {
        dao.update(entity);
    }


    public List<Book> findAll() {
        return dao.findAll();
    }


    public Book getRandomEntity() {
        return dao.getRandomEntity();
    }
}

