package pl.psi.wildfly_performance_testing.service;

import pl.psi.wildfly_performance_testing.dao.ACrudService;
import pl.psi.wildfly_performance_testing.model.big.A;
import pl.psi.wildfly_performance_testing.model.big.B;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by ftrela on 2016-07-07.
 */
@Stateless
class SubService1 {
    @Inject
    private ACrudService aCrudService;

    @Inject
    Logger logger;

    private Random random = new Random(456);

    void calculate1(int howManyRandomEntities) {
        long t1 = System.currentTimeMillis();
        List<A> aRandomList = aCrudService.findRandomEntities(howManyRandomEntities);
        double newDoubleAttribute1 = calculateNewDoubleAttribute1(aRandomList);
        setDoubleAttribute1ForAllEntitiesInLists(newDoubleAttribute1, aRandomList);
        addSomeNewObjects(aRandomList);
        long t2 = System.currentTimeMillis();
        aCrudService.updateAllEntities(aRandomList);
        long t3=System.currentTimeMillis();
        logger.warning("Time calc: "+(t2-t1)+" -- Time commit: "+(t3-t2));
    }

    private double calculateNewDoubleAttribute1(List<A> aList) {
        return calculateAverageOfDoubleAttribute1(aList) * random.nextDouble();
    }

    private double calculateAverageOfDoubleAttribute1(List<A> aList) {
        double sum = 0;
        for (A a : aList) {
            sum += a.getDoubleAttribute1();
        }
        return sum / aList.size();
    }

    private void setDoubleAttribute1ForAllEntitiesInLists(double newDoubleAttribute1, List<A> aList) {
        aList.forEach(a -> {
            a.setDoubleAttribute1(newDoubleAttribute1);
            setDoubleAttribute1ForBEntities(newDoubleAttribute1, a.getbList());
            a.getcList().forEach(c -> c.setDoubleAttribute1(newDoubleAttribute1));
            if (a.getD() != null) {
                a.getD().setDoubleAttribute1(newDoubleAttribute1);
                a.getD().getdList().forEach(d -> d.setDoubleAttribute1(newDoubleAttribute1));
                if (a.getD().getG() != null) {
                    a.getD().getG().setDoubleAttribute1(newDoubleAttribute1);
                }
            }
        });
    }

    private void setDoubleAttribute1ForBEntities(double newDoubleAttribute1, List<B> bList) {
        bList.forEach(b -> {
            b.setDoubleAttribute1(newDoubleAttribute1);
            b.geteList().forEach(e -> {
                e.setDoubleAttribute1(newDoubleAttribute1);
                if (e.getH() != null) {
                    e.getH().setDoubleAttribute1(newDoubleAttribute1);
                }
            });
            b.getfList().forEach(f -> {
                f.setDoubleAttribute1(newDoubleAttribute1);
                f.getcList().forEach(c -> c.setDoubleAttribute1(newDoubleAttribute1));
            });
        });
    }

    private void addSomeNewObjects(List<A> aRandomList) {
        aRandomList.forEach(a -> {
            a.setDate(new Date());
            a.getbList().add(new B());
        });
    }
}
