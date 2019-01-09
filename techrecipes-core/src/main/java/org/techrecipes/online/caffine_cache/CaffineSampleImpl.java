package org.techrecipes.online.caffine_cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
@CacheConfig(cacheNames = "caffineFakeUsers")
public class CaffineSampleImpl {
    Logger logger = LoggerFactory.getLogger(CaffineSampleImpl.class);
    Long key;
    List<CaffineFakeUser> fakeUserList = new ArrayList<CaffineFakeUser>();
    @CachePut(key = "#input", unless = "#result==null")
    public CaffineFakeUser createFakeUser(CaffineFakeUser fakeUser) {
        logger.debug("Executing the cache for A Based users");
        fakeUserList.add(fakeUser);
        return fakeUser;
    }
    @Cacheable(unless = "#result==null")
    public CaffineFakeUser getFakeUser(Long input) {
        logger.debug("Executing the cache for A Based users");
        CaffineFakeUser caffineFakeUser = fakeUserList
          .stream()
          .filter(fakeUser -> fakeUser
            .getId()
            .equals(input))
          .findFirst().get();
        return caffineFakeUser;
    }
    @Caching(evict = {
      @CacheEvict(value = "caffineFakeUser", allEntries = true)
    })
    public void clearAllCaches() {
        logger.info("Cleared all caches");
    }
}
