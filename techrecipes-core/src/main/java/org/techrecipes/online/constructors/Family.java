package org.techrecipes.online.constructors;

public class Family {

  //Telescopic constructors sample
  final String Father = "F1";
  final String Mother = "M1";
  final int motherAge = 35;
  final String child1;
  final String child2;

  final String child3;

  public Family() {
    this("", "", "");
  }

  public Family(String child1) {
    this(child1, "", "");
  }

  public Family(String child1, String child2) {
    this(child1, child2, "");
  }

  public Family(String child1, String child2, String child3) {
    this.child1 = child1;
    this.child2 = child2;
    this.child3 = child3;
  }

  @Override
  public String toString() {
    StringBuilder startupFamily = new StringBuilder("Family{" +
        "Father='" + Father + '\'' +
        ", Mother='" + Mother + '\'');
    if (!child1.isEmpty()) {
      startupFamily.append(", child1='" + child1 + '\'');
    }
    if (!child2.isEmpty()) {
      startupFamily.append(", child2='" + child2 + '\'');
    }
    if (!child3.isEmpty()) {
      startupFamily.append(", child3='" + child3 + '\'');
    }
    startupFamily.append('}');
    return startupFamily.toString();
  }
}
