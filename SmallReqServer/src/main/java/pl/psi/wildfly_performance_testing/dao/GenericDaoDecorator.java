package pl.psi.wildfly_performance_testing.dao;

import pl.psi.wildfly_performance_testing.model.WithK;

import java.util.List;

/**
 * Created by mblaszyk on 2016-07-08.
 */
abstract class GenericDaoDecorator<T extends WithK> implements GenericDaoIf<T> {
    GenericDaoIf<T> basicDao;

    GenericDaoDecorator(GenericDaoIf<T> basicDao){
        this.basicDao = basicDao;

    }

    @Override
    public void create(T entity) {
        basicDao.create(entity);
    }

    @Override
    public void remove(T entity) {
        basicDao.remove(entity);
    }

    @Override
    public void update(T entity) {
        basicDao.update(entity);
    }

    @Override
    public List<T> findAll() {
        return basicDao.findAll();
    }

    @Override
    public T getRandomEntity() {
        return basicDao.getRandomEntity();
    }
}
