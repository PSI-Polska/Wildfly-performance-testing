package pl.psi.wildfly_performance_testing.dao;

import pl.psi.wildfly_performance_testing.model.small.Address;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by mblaszyk on 2016-07-05.
 */

@Singleton
public class AddressCrudService{

    @Inject
    EntityManager entityManager;

    @Inject
    GenericDaoIf<Address> dao;



    public void create(Address entity) {
        dao.create(entity);
    }


    public void remove(Address entity) {
        dao.remove(entity);
    }


    public void update(Address entity) {
        dao.update(entity);
    }


    public List<Address> findAll() {
        return dao.findAll();
    }


    public Address getRandomEntity() {
        return dao.getRandomEntity();
    }
}
