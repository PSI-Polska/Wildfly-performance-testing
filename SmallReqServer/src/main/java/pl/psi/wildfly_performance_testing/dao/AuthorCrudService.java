package pl.psi.wildfly_performance_testing.dao;

import pl.psi.wildfly_performance_testing.model.small.Address;
import pl.psi.wildfly_performance_testing.model.small.Author;

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
public class AuthorCrudService{
    @Inject
    EntityManager entityManager;

    @Inject
    GenericDaoIf<Author> dao;



    public void create(Author entity) {
        dao.create(entity);
    }


    public void remove(Author entity) {
        dao.remove(entity);
    }


    public void update(Author entity) {
        dao.update(entity);
    }


    public List<Author> findAll() {
        return dao.findAll();
    }


    public Author getRandomEntity() {
        return dao.getRandomEntity();
    }
}

