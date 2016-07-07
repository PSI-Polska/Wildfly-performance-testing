package pl.psi.wildfly_performance_testing.service;

import pl.psi.wildfly_performance_testing.dao.ADao;
import pl.psi.wildfly_performance_testing.model.big.A;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by ftrela on 2016-07-06.
 */
@Stateless
public class AService {
    @Inject
    private ADao aDao;

    public List<A> getAList() {
        List<A> allA = aDao.findAllEntities();
        // lazy loading!
        allA.forEach(a -> {
            a.getbList().size();
            a.getcList().size();
        });
        return allA;
    }

    public void createA(A a) {
        aDao.create(a);
    }
}
