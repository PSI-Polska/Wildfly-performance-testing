package pl.psi.wildfly_performance_testing.dao;

import pl.psi.wildfly_performance_testing.model.WithK;

import java.util.List;

/**
 * Created by mblaszyk on 2016-07-08.
 */
public interface GenericDaoIf<T extends WithK> {
    void create(T entity);

    void remove(T entity);

    void update(T entity);

    List<T> findAll();

    T getRandomEntity();
}
