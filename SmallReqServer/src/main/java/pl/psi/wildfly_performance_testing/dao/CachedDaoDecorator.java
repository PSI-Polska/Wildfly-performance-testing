package pl.psi.wildfly_performance_testing.dao;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Lists;
import pl.psi.wildfly_performance_testing.model.WithK;

import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by mblaszyk on 2016-07-08.
 */
public class CachedDaoDecorator<T extends WithK> implements GenericDaoIf<T> {


    private Cache<Long, T> cache = CacheBuilder.newBuilder().build();

    GenericDaoIf<T> decoratedDao;
    private Random random = new Random(4283);

    CachedDaoDecorator(GenericDaoIf<T> decoratedDao) {
        this.decoratedDao = decoratedDao;
    }

    @Override
    public void create(T entity) {
        decoratedDao.create(entity);
        cache.put(entity.getId(), entity);
    }

    @Override
    public void remove(T entity) {
        decoratedDao.remove(entity);
        cache.invalidate(entity.getId());
    }

    @Override
    public void update(T entity) {
        decoratedDao.update(entity);
        cache.put(entity.getId(), entity);
    }

    @Override
    public List<T> findAll() {
        return cache.asMap().values().stream().collect(Collectors.toList());
    }

    @Override
    public T getRandomEntity() {
        ArrayList<Long> allKeys = Lists.newArrayList(cache.asMap().keySet());

        int rand = random.nextInt(allKeys.size());
        Long randKey = allKeys.get(rand);

        return cache.getIfPresent(randKey);
    }
}
