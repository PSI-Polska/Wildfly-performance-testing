package pl.psi.wildfly_performance_testing.util;

import pl.psi.wildfly_performance_testing.service.SmallService;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.apache.logging.log4j.Logger;

/**
 * Created by mblaszyk on 2016-07-08.
 */
@Singleton
@Startup
public class Seeder {
    private final int numberOfAuthors = 3000;
    private final int numberOfBooks = 7000;
    private final int bookBatchSize = 200;

    @Inject
    SmallService sService;

    @Inject
    private Logger logger;

    @PostConstruct
    public void initialize(){
        initAuthors();

        initBooks();
    }


    private void initBooks() {
        for (int i = 0; i < numberOfBooks / bookBatchSize; i++) {
            initBooksBatch(bookBatchSize);
            logger.info("Books populated: " + (i * bookBatchSize) * 100 / numberOfBooks + "%");

        }
    }

    @Transactional
    private void initBooksBatch(int batch) {
        for (int i = 0; i < batch; i++) {
            sService.createBook();

        }
    }

    @Transactional
    private void initAuthors() {
        for (int i = 0; i < numberOfAuthors; i++) {
            sService.createAuthor(i);
            if((i%300)==0)
            logger.info("Authors populated: " + i * 100 / numberOfAuthors + "%");
        }
    }


}
