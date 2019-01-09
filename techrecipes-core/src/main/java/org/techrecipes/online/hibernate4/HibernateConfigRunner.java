package org.techrecipes.online.hibernate4;
import org.techrecipes.online.hibernate4.dao.BasicDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HibernateConfigRunner {
  public static void main(String args[]) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.register(Sample365HibernateConfig.class);
    ctx.register(BasicDao.class);
    ctx.refresh();
    BasicDao sample365HibernateConfig = ctx.getBean(BasicDao.class);
    System.out.println("sample365HibernateConfig :" + sample365HibernateConfig.getCurrentSession());
  }
}
