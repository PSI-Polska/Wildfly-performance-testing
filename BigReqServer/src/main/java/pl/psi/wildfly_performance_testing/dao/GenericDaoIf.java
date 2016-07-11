package pl.psi.wildfly_performance_testing.dao;

import pl.psi.wildfly_performance_testing.model.WithK;

import java.util.List;

/**
 * Created by ftrela on 2016-07-11.
 */
public interface GenericDaoIf<T extends WithK> {
    void create(T entity);

    void remove(T entity);

    void update(T entity);

    void updateAllEntities(List<T> entities);

    List<T> findAll();

    List<T> findRandomEntities(int howMany);
}
