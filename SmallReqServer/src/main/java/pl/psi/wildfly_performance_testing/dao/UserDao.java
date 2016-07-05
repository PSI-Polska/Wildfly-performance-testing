package pl.psi.wildfly_performance_testing.dao;

import pl.psi.wildfly_performance_testing.model.User;

import javax.ejb.Stateless;

/**
 * Created by mbocian on 2016-05-04.
 */
@Stateless
public class UserDao extends GenericDao<User> {
    public UserDao() {
        super(User.class);
    }
}
