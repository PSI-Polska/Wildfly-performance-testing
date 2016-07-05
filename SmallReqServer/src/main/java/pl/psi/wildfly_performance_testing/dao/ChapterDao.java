package pl.psi.wildfly_performance_testing.dao;

import pl.psi.wildfly_performance_testing.model.small.Chapter;

import javax.ejb.Stateless;

/**
 * Created by mblaszyk on 2016-07-05.
 */
@Stateless
public class ChapterDao extends GenericDao<Chapter> {
    public ChapterDao() {
        super(Chapter.class);
    }
}
