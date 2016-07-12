package pl.psi.wildfly_performance_testing.util;

import org.apache.logging.log4j.LogManager;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class Resources {

    @Produces
    @PersistenceContext(name = "PersistenceUnit")
    private EntityManager em;

    @Produces
    public org.apache.logging.log4j.Logger produceLog(InjectionPoint injectionPoint) {
        return LogManager.getLogger(injectionPoint.getMember().getDeclaringClass().getName());

    }
}