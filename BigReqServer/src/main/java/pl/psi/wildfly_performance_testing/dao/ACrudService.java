package pl.psi.wildfly_performance_testing.dao;

import pl.psi.wildfly_performance_testing.model.big.A;

import javax.ejb.Singleton;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by ftrela on 2016-07-11.
 */
@Singleton
public class ACrudService {
    @Inject
    private GenericDaoIf<A> dao;

    public void create(A entity) {
        dao.create(entity);
    }

    public void remove(A entity) {
        dao.remove(entity);
    }

    public void update(A entity) {
        dao.update(entity);
    }

    public void updateAllEntities(List<A> entities) {
        dao.updateAllEntities(entities);
    }

    public List<A> findAll() {
        return dao.findAll();
    }

    public List<A> findRandomEntities(int howMany) {
        return dao.findRandomEntities(howMany);
    }
}
