package pl.psi.wildfly_performance_testing.dao;

import pl.psi.wildfly_performance_testing.model.big.A;

import javax.ejb.Stateless;

/**
 * Created by ftrela on 2016-07-05.
 */
@Stateless
public class ADao extends GenericDao<A> {
    public ADao() {
        super(A.class);
    }
}
