package pl.psi.wildfly_performance_testing.dao;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import pl.psi.wildfly_performance_testing.model.WithK;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by mbocian on 2016-05-04.
 */
public class CoreDao<T extends WithK> implements GenericDaoIf<T> {

    private EntityManager entityManager;
    private Class<T> clazz;


    public CoreDao(Class<T> clazz, EntityManager entityManager) {
        this.clazz = clazz;
        this.entityManager = entityManager;
    }

    @Override
    public void create(T entity) {
        entityManager.persist(entity);

    }

    @Override
    public void remove(T entity) {
        entityManager.remove(entity);

    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);

    }

    @Override
    public List<T> findAll() {
        return (List<T>) entityManager.createQuery("SELECT t FROM " + clazz.getSimpleName() + " t").getResultList();
    }

    @Override
    public T getRandomEntity() {
        List<T> results = entityManager.createQuery("SELECT t FROM " + clazz.getSimpleName() + " t order by RANDOM()").setMaxResults(1).getResultList();

        T foundEntity = null;
        if (!results.isEmpty()) {
            foundEntity = results.get(0);
        }
        return foundEntity;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager em) {
        this.entityManager = em;
    }
}
