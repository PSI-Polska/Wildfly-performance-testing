package pl.psi.wildfly_performance_testing.dao;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Lists;
import pl.psi.wildfly_performance_testing.model.WithK;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by mblaszyk on 2016-07-08.
 */
public class CachedDaoDecorator<T extends WithK> extends GenericDaoDecorator<T> {

    private Cache<Long,T> cache= CacheBuilder.newBuilder().build();

    CachedDaoDecorator(GenericDaoIf<T> basicDao) {
        super(basicDao);
    }

    @Override
    public void create(T entity) {
        super.create(entity);
        cache.put(entity.getId(),entity);
    }

    @Override
    public void remove(T entity) {
        super.remove(entity);
        cache.invalidate(entity.getId());
    }

    @Override
    public void update(T entity) {
        super.update(entity);
        cache.put(entity.getId(),entity);
    }

    @Override
    public List<T> findAll() {
        List<T> all = new ArrayList<T>(cache.asMap().values());
        return all;

    }

    @Override
    public T getRandomEntity() {
        ArrayList<Long> allKeys = Lists.newArrayList(cache.asMap().keySet());
        int rand = new Random().nextInt(allKeys.size());
        Long randKey = allKeys.get(rand);

        return cache.getIfPresent(randKey);
    }
}
