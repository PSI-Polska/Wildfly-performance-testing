package pl.psi.wildfly_performance_testing.dao;

import pl.psi.wildfly_performance_testing.model.big.C;

import javax.ejb.Stateless;

/**
 * Created by ftrela on 2016-07-08.
 */
@Stateless
public class CDao extends GenericDao<C> {
    public CDao() {
        super(C.class);
    }
}
