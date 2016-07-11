package pl.psi.wildfly_performance_testing.dao;

import pl.psi.wildfly_performance_testing.model.big.C;

import javax.ejb.Singleton;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by ftrela on 2016-07-11.
 */
@Singleton
public class CCrudService {
    @Inject
    private GenericDaoIf<C> dao;

    public void create(C entity) {
        dao.create(entity);
    }

    public void remove(C entity) {
        dao.remove(entity);
    }

    public void update(C entity) {
        dao.update(entity);
    }

    public void updateAllEntities(List<C> entities) {
        dao.updateAllEntities(entities);
    }

    public List<C> findAll() {
        return dao.findAll();
    }

    public List<C> findRandomEntities(int howMany) {
        return dao.findRandomEntities(howMany);
    }
}
