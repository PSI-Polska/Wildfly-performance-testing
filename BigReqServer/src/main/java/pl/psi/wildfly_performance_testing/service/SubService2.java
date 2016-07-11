package pl.psi.wildfly_performance_testing.service;

import pl.psi.wildfly_performance_testing.dao.CCrudService;
import pl.psi.wildfly_performance_testing.model.big.C;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by ftrela on 2016-07-07.
 */
@Stateless
class SubService2 {
    @Inject
    private CCrudService cCrudService;

    double calculateMedian() {
        List<C> cList = cCrudService.findAll();
        if (cList.isEmpty()) {
            throw new IllegalStateException("cList is empty");
        }
        cList.sort((o1, o2) -> Double.compare(o1.getDoubleAttribute1(), o2.getDoubleAttribute1()));

        int n = cList.size();
        double median = 0.0;
        if (n % 2 == 0) {
            median = (cList.get(n / 2).getDoubleAttribute1() + cList.get((n / 2) + 1).getDoubleAttribute1()) / 2;
        } else {
            median = cList.get((n + 1) / 2).getDoubleAttribute1();
        }

        for (C c : cList) {
            c.setDoubleAttribute2(median);
        }
        return median;
    }
}
