package pl.psi.wildfly_performance_testing.service;

import pl.psi.wildfly_performance_testing.dao.EDao;
import pl.psi.wildfly_performance_testing.model.big.E;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by ftrela on 2016-07-07.
 */
@Stateless
class SubService2 {
    @Inject
    private EDao eDao;

    double calculateMedian() {
        List<E> eList = eDao.findAllEntities();
        if (eList.isEmpty()) {
            throw new IllegalStateException("eList is empty");
        }
        eList.sort((o1, o2) -> Double.compare(o1.getDoubleAttribute1(), o2.getDoubleAttribute1()));

        int n = eList.size();
        double median = 0.0;
        if (n % 2 == 0) {
            median = (eList.get(n / 2).getDoubleAttribute1() + eList.get((n / 2) + 1).getDoubleAttribute1()) / 2;
        } else {
            median = eList.get((n + 1) / 2).getDoubleAttribute1();
        }

        for (E e : eList) {
            e.setDoubleAttribute2(median);
        }
        return median;
    }
}
