package org.techrecipes.online.spEL.users;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class SpELUserRunner {
  public static void main(String args[]) {
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
    annotationConfigApplicationContext.register(SpELUserParserConfiguration.class);
    annotationConfigApplicationContext.refresh();
    SpELUser speELuser = annotationConfigApplicationContext.getBean(SpELUser.class);
    System.out.println(speELuser.getName());
    System.out.println(speELuser.getOccupation());
  }
}
