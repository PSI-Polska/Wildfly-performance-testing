package pl.psi.wildfly_performance_testing.dao;

import pl.psi.wildfly_performance_testing.model.small.Address;
import pl.psi.wildfly_performance_testing.model.small.Author;
import pl.psi.wildfly_performance_testing.model.small.Book;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by mblaszyk on 2016-07-08.
 */
public class GenericDaoProducer {

    @Inject
    EntityManager em;

    @Produces
    public GenericDaoIf<Address> produAddressCachedDaoDecorator() {
        return new CachedDaoDecorator(new CoreDao(Address.class, em));
    }
    @Produces
    public GenericDaoIf<Book> produBookCachedDaoDecorator() {
        return new CachedDaoDecorator(new CoreDao(Book.class, em));
    }
    @Produces
    public GenericDaoIf<Author> produAuthorCachedDaoDecorator() {
        return new CachedDaoDecorator(new CoreDao(Author.class, em));
    }
}
