package com.da2win.springbootlesson10;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@EnableCaching
public class CacheConfiguration {

    @Bean
    public CacheManager simpleCacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();

        Cache cache = new ConcurrentMapCache("cache-1");
        Cache personsCache = new ConcurrentMapCache("persons");

        simpleCacheManager.setCaches(Arrays.asList(cache, personsCache));

        return simpleCacheManager;
    }
}
