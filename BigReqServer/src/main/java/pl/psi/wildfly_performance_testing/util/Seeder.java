package pl.psi.wildfly_performance_testing.util;

import pl.psi.wildfly_performance_testing.dao.ACrudService;
import pl.psi.wildfly_performance_testing.dao.CCrudService;
import pl.psi.wildfly_performance_testing.model.big.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by ftrela on 2016-07-07.
 */
@Singleton
@Startup
public class Seeder {
    private final int numberOfObjects = 300;
    private final int creatingObjectProbabilityInPercentage = 50;
    private Random random = new Random(94);

    @Inject
    private ACrudService aCrudService;

    @Inject
    private CCrudService cCrudService;

    @Inject
    private Logger logger;

    @PostConstruct
    @Transactional
    public void initialize() {
        for (int i = 0; i < numberOfObjects; i++) {
            A a = new A();
            a.setDate(new Date());
            a.setTextAttribute1("someText" + String.valueOf(random.nextLong()));
            a.setTextAttribute2("someText" + String.valueOf(random.nextLong()));
            a.setTextAttribute3("someText" + String.valueOf(random.nextLong()));
            a.setDoubleAttribute1(random.nextDouble());
            a.setDoubleAttribute2(random.nextDouble());
            a.setLongAttribute1(random.nextLong());

            seedBObjectsIntoList(a.getbList());
            seedCObjectsIntoList(a.getcList());
            seedDObjectIntoAObject(a);

            aCrudService.create(a);

            logger.info("Logger populated: " + i * 100 / numberOfObjects + "%");
        }
    }

    private boolean objectHaveToBeCreated() {
        return random.nextInt(100 / creatingObjectProbabilityInPercentage) == 0;
    }

    private void seedBObjectsIntoList(List<B> bList) {
        for (int i = 0; i < random.nextInt(numberOfObjects); i++) {
            if (objectHaveToBeCreated()) {
                B b = new B();
                b.setDoubleAttribute1(random.nextDouble());
                b.setDoubleAttribute2(random.nextDouble());
                bList.add(b);
                seedEObjectsIntoList(b.geteList());
                seedFObjectsIntoList(b.getfList());
            }
        }
    }

    private void seedCObjectsIntoList(List<C> cList) {
        for (int i = 0; i < random.nextInt(numberOfObjects); i++) {
            if (objectHaveToBeCreated()) {
                C c = new C();
                c.setDoubleAttribute1(random.nextDouble());
                c.setDoubleAttribute2(random.nextDouble());
                cList.add(c);
                cCrudService.create(c);
            }
        }
    }

    private void seedDObjectsIntoList(List<D> dList) {
        for (int i = 0; i < random.nextInt(numberOfObjects); i++) {
            if (objectHaveToBeCreated()) {
                D d = new D();
                d.setDoubleAttribute1(random.nextDouble());
                d.setDoubleAttribute2(random.nextDouble());
                dList.add(d);
                seedGObjectIntoDObject(d);
            }
        }
    }

    private void seedEObjectsIntoList(List<E> eList) {
        for (int i = 0; i < random.nextInt(numberOfObjects); i++) {
            if (objectHaveToBeCreated()) {
                E e = new E();
                e.setDoubleAttribute1(random.nextDouble());
                e.setDoubleAttribute2(random.nextDouble());
                eList.add(e);
                if (objectHaveToBeCreated()) {
                    H h = new H();
                    h.setDoubleAttribute1(random.nextDouble());
                    h.setDoubleAttribute2(random.nextDouble());
                    e.setH(h);
                }
            }
        }
    }

    private void seedFObjectsIntoList(List<F> fList) {
        for (int i = 0; i < random.nextInt(numberOfObjects); i++) {
            if (objectHaveToBeCreated()) {
                F f = new F();
                f.setDoubleAttribute1(random.nextDouble());
                f.setDoubleAttribute2(random.nextDouble());
                fList.add(f);
                seedCObjectsIntoList(f.getcList());
            }
        }
    }

    private void seedDObjectIntoAObject(A a) {
        if (objectHaveToBeCreated()) {
            D d = new D();
            d.setDoubleAttribute1(random.nextDouble());
            d.setDoubleAttribute2(random.nextDouble());
            a.setD(d);
            seedDObjectsIntoList(d.getdList());
            seedGObjectIntoDObject(d);
        }
    }

    private void seedGObjectIntoDObject(D d) {
        if (objectHaveToBeCreated()) {
            G g = new G();
            g.setDoubleAttribute1(random.nextDouble());
            g.setDoubleAttribute2(random.nextDouble());
            d.setG(g);
        }
    }
}
