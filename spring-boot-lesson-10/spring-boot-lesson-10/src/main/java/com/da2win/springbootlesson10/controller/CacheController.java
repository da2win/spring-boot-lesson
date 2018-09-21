package com.da2win.springbootlesson10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    @Qualifier("simpleCacheManager")
    private CacheManager cacheManager;

    @PostMapping("/save")
    public Map<String, Object> save(@RequestParam String key, @RequestParam String value) {
        Cache cache = cacheManager.getCache("cache-1");

        cache.put(key, value);

        Map<String, Object> result = new HashMap<>();

        result.put(key, value);

        return result;
    }
}
