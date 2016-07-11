package pl.psi.wildfly_performance_testing.dao;

import pl.psi.wildfly_performance_testing.model.WithK;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by mbocian on 2016-05-04.
 */
class CoreDao<T extends WithK> implements GenericDaoIf<T> {

    private EntityManager entityManager;
    private Class<T> clazz;


    CoreDao(Class<T> clazz, EntityManager entityManager) {
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
    public void updateAllEntities(List<T> entities) {
        entities.forEach(this::update);
    }

    @Override
    public List<T> findAll() {
        return (List<T>) entityManager.createQuery("SELECT t FROM " + clazz.getSimpleName() + " t").getResultList();
    }

    @Override
    public List<T> findRandomEntities(int howMany) {
        return (List<T>) entityManager.createQuery("SELECT t FROM " + clazz.getSimpleName() + " t ORDER BY RAND()").setMaxResults(howMany).getResultList();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager em) {
        this.entityManager = em;
    }
}
