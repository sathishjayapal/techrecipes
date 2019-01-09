package org.techrecipes.online.spEL.users;
import org.springframework.beans.factory.annotation.Autowired;
public class SpELUser {
  @Autowired
  private String name;
  @Autowired
  private String occupation;
  public String getName() {
    return name;
  }
  public String getOccupation() {
    return occupation;
  }
}
