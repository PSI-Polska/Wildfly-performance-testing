package pl.psi.wildfly_performance_testing.dao;

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

    public void updateAllEntities(List<T> entities) {
        entities.forEach(this::update);
    }

    public List<T> findAllEntities() {
        return (List<T>) entityManager.createQuery("SELECT t FROM " + clazz.getSimpleName() + " t").getResultList();
    }

    public List<T> findRandomEntities(int howMany) {
        return (List<T>) entityManager.createQuery("SELECT t FROM " + clazz.getSimpleName() + " t ORDER BY RAND()").setMaxResults(howMany).getResultList();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
