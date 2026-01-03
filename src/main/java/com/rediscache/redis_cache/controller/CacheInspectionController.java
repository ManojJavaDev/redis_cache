package com.rediscache.redis_cache.controller;


import com.rediscache.redis_cache.service.CacheInspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cache")
public class CacheInspectionController {

    @Autowired
    CacheInspectionService cacheInspectionService;

    @GetMapping("/cacheData")
    public void getCacheInfo(){
        cacheInspectionService.printCacheContent("userProfile");
    }


}
