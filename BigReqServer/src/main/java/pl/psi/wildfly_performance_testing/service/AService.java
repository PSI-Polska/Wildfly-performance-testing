package pl.psi.wildfly_performance_testing.service;

import pl.psi.wildfly_performance_testing.dao.ACrudService;
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
    private ACrudService aCrudService;

    public List<A> getAList() {
        return aCrudService.findAll();
    }

    public void createA(A a) {
        aCrudService.create(a);
    }
}
