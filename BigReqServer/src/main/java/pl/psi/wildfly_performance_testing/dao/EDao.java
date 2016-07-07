package pl.psi.wildfly_performance_testing.dao;

import pl.psi.wildfly_performance_testing.model.big.E;

import javax.ejb.Stateless;

/**
 * Created by ftrela on 2016-07-07.
 */
@Stateless
public class EDao extends GenericDao<E> {
    public EDao() {
        super(E.class);
    }
}
