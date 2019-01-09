package org.techrecipes.online.caffine_cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 * Created by sathishjayapal on 2/15/18.
 */
@Cacheable
public class CaffineSampleRunner {
    public static void main(String args[]) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(CaffeineConfig.class);
        ctx.register(CaffineSampleImpl.class);
        ctx.refresh();
        CaffineSampleImpl caffineSampleImpl = ctx.getBean( CaffineSampleImpl.class);
        for (long i = 0; i < 11; i++) {
            CaffineFakeUser caffineFakeUser = new CaffineFakeUser(i);
            caffineSampleImpl.createFakeUser(caffineFakeUser);
            System.out.println("The one that I got is " +i+ caffineFakeUser
              .returnMe()
              .toString());
        }
        CaffineFakeUser cf10= caffineSampleImpl.getFakeUser(100L);
        System.out.println("The one that I got is " + cf10
          .returnMe()
          .toString());
    }
}
