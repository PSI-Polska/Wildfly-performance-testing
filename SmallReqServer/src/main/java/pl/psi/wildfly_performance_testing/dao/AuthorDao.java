package pl.psi.wildfly_performance_testing.dao;

import pl.psi.wildfly_performance_testing.model.small.Author;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by mblaszyk on 2016-07-05.
 */
@Stateless
public class AuthorDao extends GenericDao<Author> {
    public AuthorDao() {
        super(Author.class);
    }


}
