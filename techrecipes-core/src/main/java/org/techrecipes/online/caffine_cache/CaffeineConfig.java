package org.techrecipes.online.caffine_cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Configuration
@Component
public class CaffeineConfig {
    @Bean
    public CacheManager cacheManager() {
        //Caffine uses implied algorithm. It uses the recency and probablic algorithm.
        String spaceAsString = "initialCapacity=10,maximumSize=100,expireAfterAccess=5m,recordStats";
        CaffeineCacheManager caffineCacheManager = new CaffeineCacheManager("caffineFakeUsers");
        caffineCacheManager.setCacheSpecification(spaceAsString);
        caffineCacheManager.setAllowNullValues(false);
        return caffineCacheManager;
    }
}