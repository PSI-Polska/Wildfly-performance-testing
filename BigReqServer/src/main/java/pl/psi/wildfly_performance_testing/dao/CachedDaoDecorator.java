package pl.psi.wildfly_performance_testing.dao;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Lists;
import pl.psi.wildfly_performance_testing.model.WithK;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by ftrela on 2016-07-11.
 */
class CachedDaoDecorator<T extends WithK> implements GenericDaoIf<T> {

    private Cache<Long, T> cache = CacheBuilder.newBuilder().build();

    private GenericDaoIf<T> decoratedDao;

    private Random random = new Random(123);

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
    public void updateAllEntities(List<T> entities) {
        decoratedDao.updateAllEntities(entities);
        entities.forEach(t -> cache.put(t.getId(), t));
    }

    @Override
    public List<T> findAll() {
        return cache.asMap().values().stream().collect(Collectors.toList());
    }

    @Override
    public List<T> findRandomEntities(int howMany) {
        List<T> randomEntities = new ArrayList<T>();

        List<Long> allKeys = Lists.newArrayList(cache.asMap().keySet());
        for (int i = 0; i < howMany; i++) {
            int randomIndex = random.nextInt(allKeys.size());
            long randomKey = allKeys.get(randomIndex);

            T value = cache.getIfPresent(randomKey);
            if (value != null) {
                randomEntities.add(value);
            } else {
                throw new IllegalStateException(randomKey + " key not found");
            }

        }
        return randomEntities;
    }
}
