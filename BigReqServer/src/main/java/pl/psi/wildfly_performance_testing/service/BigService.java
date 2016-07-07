package pl.psi.wildfly_performance_testing.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by ftrela on 2016-07-05.
 */
@Stateless
public class BigService {
    @Inject
    private SubService1 subService1;

    @Inject
    private SubService2 subService2;

    public void calculate1(int howManyRandomEntities) {
        subService1.calculate1(howManyRandomEntities);
    }

    public double calculate2() {
        return subService2.calculateMedian();
    }
}
