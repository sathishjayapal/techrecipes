package org.techrecipes.online.spEL;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 * Created by sjayapal on 11/27/2017.
 */
public class SpELRunner {
    public static void main(String args[]) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(SpELConfig.class);
        annotationConfigApplicationContext.refresh();
        String[] beanNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        SpELConfig spELConfig = annotationConfigApplicationContext.getBean( SpELConfig.class);
        System.out.println(spELConfig.getFoo());
    }
}
