package pl.psi.wildfly_performance_testing.dao;

import pl.psi.wildfly_performance_testing.model.big.A;
import pl.psi.wildfly_performance_testing.model.big.C;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by ftrela on 2016-07-11.
 */
public class GenericDaoProducer {
    @Inject
    private EntityManager entityManager;

    @Produces
    public GenericDaoIf<A> produceACachedDaoDecorator() {
        return new CachedDaoDecorator<>(new CoreDao<>(A.class, entityManager));
    }

    @Produces
    public GenericDaoIf<C> produceCCachedDaoDecorator() {
        return new CachedDaoDecorator<>(new CoreDao<>(C.class, entityManager));
    }
}
