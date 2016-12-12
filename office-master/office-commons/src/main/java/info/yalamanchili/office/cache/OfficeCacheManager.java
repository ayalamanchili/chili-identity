/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.cache;

import info.chili.spring.SpringContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Component
public class OfficeCacheManager {

    @Autowired
    protected EhCacheCacheManager cacheManager;

    public void cleanAll() {
        for (String cacheName : cacheManager.getCacheNames()) {
            cacheManager.getCache(cacheName).clear();
        }
    }

    public void clearCache(String cacheName) {
        getCacheWithName(cacheName).clear();
    }

    public void evictObjectFromCache(String cacheName, Object evictObj) {
        getCacheWithName(cacheName).evict(evictObj);
    }

    protected Cache getCacheWithName(String cacheName) {
        Cache cache = cacheManager.getCache(cacheName);
        if (cache == null) {
            throw new RuntimeException("Cache not found:" + cacheName);
        }
        return cache;
    }

    public boolean contains(String region, String key) {
        return cacheManager.getCache(region).get(key) != null;
    }

    public void put(String region, Object key, Object value) {
        cacheManager.getCache(region).put(key, value);
    }

    public Object get(String region, Object key) {
        if (cacheManager.getCache(region).get(key) != null) {
            return cacheManager.getCache(region).get(key).get();
        } else {
            return null;
        }

    }

    public static OfficeCacheManager instance() {
        return SpringContext.getBean(OfficeCacheManager.class);
    }
}
