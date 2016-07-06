package pl.psi.wildfly_performance_testing.dao;

import org.hibernate.criterion.Criterion;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by mbocian on 2016-05-04.
 */
@Stateless
public abstract class GenericDao<T> {
    @Inject
    private EntityManager entityManager;
    private Class<T> clazz;

    public GenericDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void create(T entity) {
        entityManager.persist(entity);
    }

    public void remove(T entity) {
        entityManager.remove(entity);
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public List<T> findAll() {
        return (List<T>) entityManager.createQuery("SELECT t FROM " + clazz.getSimpleName() + " t").getResultList();
    }

    public T getRandomEntity() {
        List<T> results = entityManager.createQuery("SELECT t FROM " + clazz.getSimpleName() + " t order by RANDOM()").setMaxResults(1).getResultList();

        T foundEntity = null;
        if(!results.isEmpty()){
            foundEntity = results.get(0);
        }
        return foundEntity;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
