package org.techrecipes.online.hibernate4.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class BasicDao {
  @Autowired
  SessionFactory sessionFactory;
  public Session getCurrentSession() {
    return sessionFactory.getCurrentSession();
  }
}
