package pl.psi.wildfly_performance_testing.dao;

import pl.psi.wildfly_performance_testing.model.small.Book;

import javax.ejb.Stateless;

/**
 * Created by mblaszyk on 2016-07-05.
 */
@Stateless
public class BookDao extends GenericDao<Book> {
    public BookDao() {
        super(Book.class);
    }
}
