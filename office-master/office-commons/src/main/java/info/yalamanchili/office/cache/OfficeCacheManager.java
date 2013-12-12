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
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Component
public class OfficeCacheManager {

    public void cleanAll() {
        for (String cacheName : getCacheManager().getCacheNames()) {
            getCacheManager().getCache(cacheName).clear();
        }
    }

    public void clearCache(String cacheName) {
        getCacheWithName(cacheName).clear();
    }

    public void evictObjectFromCache(String cacheName, Object evictObj) {
        getCacheWithName(cacheName).evict(evictObj);
    }

    protected Cache getCacheWithName(String cacheName) {
        Cache cache = getCacheManager().getCache(cacheName);
        if (cache == null) {
            throw new RuntimeException("Cache not found:" + cacheName);
        }
        return cache;
    }

    //TODO user autowire
    protected SimpleCacheManager getCacheManager() {
        return (SimpleCacheManager) SpringContext.getBean("cacheManager");
    }

    public static OfficeCacheManager instance() {
        return SpringContext.getBean(OfficeCacheManager.class);
    }
}
