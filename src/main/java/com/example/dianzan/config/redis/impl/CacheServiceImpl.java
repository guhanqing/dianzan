package com.example.dianzan.config.redis.impl;

import com.example.dianzan.config.redis.CacheException;
import com.example.dianzan.config.redis.CacheService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @program: demo
 * @description: 缓存接口实现类
 * @author: guhq
 * @create: 2019/06/05
 */
@Service
public class CacheServiceImpl implements CacheService {
    private static final Logger LOG = LoggerFactory.getLogger(CacheServiceImpl.class);

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Override
    public void expire(String key, int interval) throws CacheException {
        try {
            redisTemplate.expire(key, interval, TimeUnit.SECONDS);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new CacheException(e, e.getMessage());
        }
    }

    @Override
    public void expire(String key, int interval, TimeUnit unit) {
        try {
            redisTemplate.expire(key, interval, unit);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new CacheException(e, e.getMessage());
        }
    }

    @Override
    public void add(String key, Serializable value) throws CacheException {
        try {
            redisTemplate.opsForValue().set(key, value);
        } catch (Exception ex) {
            LOG.error(ex.getMessage(), ex);
            throw new CacheException(ex, ex.getMessage());
        }
    }

    @Override
    public void add(String key, Serializable value, int minutes) throws CacheException {
        try {
            redisTemplate.opsForValue().set(key, value);
            redisTemplate.expire(key, minutes, TimeUnit.MINUTES);
        } catch (Exception ex) {
            LOG.error(ex.getMessage(), ex);
            throw new CacheException(ex, ex.getMessage());
        }
    }

    @Override
    public void add(String key, Serializable value, int interval, TimeUnit unit) throws CacheException {
        try {
            redisTemplate.opsForValue().set(key, value);
            redisTemplate.expire(key, interval, unit);
        } catch (Exception ex) {
            LOG.error(ex.getMessage(), ex);
            throw new CacheException(ex, ex.getMessage());
        }
    }

    @Override
    public Serializable get(String key) throws CacheException {
        try {
            return redisTemplate.opsForValue().get(key);
        } catch (Exception ex) {
            remove(key);
            LOG.error(ex.getMessage(), ex);
            return null;
        }
    }

    @Override
    public boolean setNX(String key, Serializable value, int interval, TimeUnit unit) throws CacheException {
        boolean v = false;
        try {
            v = redisTemplate.opsForValue().setIfAbsent(key, value);
            if (v) {
                redisTemplate.expire(key, interval, unit);
            }
        } catch (Exception ex) {
            remove(key);
            LOG.error(ex.getMessage(), ex);
            return false;
        }
        return v;
    }

    @Override
    public void remove(String key) throws CacheException {
        try {
            redisTemplate.delete(key);
        } catch (Exception ex) {
            LOG.error(ex.getMessage(), ex);
            throw new CacheException(ex, ex.getMessage());
        }
    }

    @Override
    public void remove(List<String> keys) throws CacheException {
        try {
            redisTemplate.delete(keys);
        } catch (Exception ex) {
            LOG.error(ex.getMessage(), ex);
            throw new CacheException(ex, ex.getMessage());
        }
    }

    @Override
    public void removeLike(String keyPrefix) throws CacheException {
        try {
            if (StringUtils.isNotEmpty(keyPrefix)) {
                Set<String> matchedCacheKeys = redisTemplate.keys(keyPrefix + "*");
                for (String cacheKey : matchedCacheKeys) {
                    this.remove(cacheKey);
                }
            }
        } catch (Exception ex) {
            LOG.error(ex.getMessage(), ex);
            throw new CacheException(ex, ex.getMessage());
        }
    }

    @Override
    public void addList(String key, Collection<Serializable> values) throws CacheException {
        try {
            if (values != null && values.size() > 0) {
                remove(key);
                redisTemplate.opsForList().leftPushAll(key, values);
            }
        } catch (Exception ex) {
            LOG.error(ex.getMessage(), ex);
            throw new CacheException(ex, ex.getMessage());
        }
    }

    @Override
    public Long incrBy(String key, long val) throws CacheException {
        try {
            return redisTemplate.opsForValue().increment(key, val);
        } catch (Exception ex) {
            LOG.error(ex.getMessage(), ex);
            throw new CacheException(ex, ex.getMessage());
        }
    }

    @Override
    public Long incr(String key, long val, int interval, TimeUnit unit) {
        Long result = null;
        try {
            result = this.incrBy(key, val);
            if (result == 1 && val > 0) { // val小于0表示回退，所以要忽略
                redisTemplate.expire(key, interval, unit);
            }
        } catch (Exception ex) {
            LOG.error(ex.getMessage(), ex);
            throw new CacheException(ex, ex.getMessage());
        }
        return result;
    }

    @Override
    public List<Serializable> multiGet(Collection<String> keys) {
        try {
            return redisTemplate.opsForValue().multiGet(keys);
        } catch (Exception ex) {
            LOG.error(ex.getMessage(), ex);
            throw new CacheException(ex, ex.getMessage());
        }
    }

    @Override
    public void addList(String key, Collection<Serializable> values, int minutes) throws CacheException {
        try {
            remove(key);
            redisTemplate.opsForList().leftPushAll(key, values);
            redisTemplate.expire(key, minutes, TimeUnit.MINUTES);
        } catch (Exception ex) {
            LOG.error(ex.getMessage(), ex);
            throw new CacheException(ex, ex.getMessage());
        }
    }
}
