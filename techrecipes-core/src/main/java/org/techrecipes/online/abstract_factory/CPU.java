package org.techrecipes.online.abstract_factory;
public abstract class CPU {
  @Override
  public String toString() {
    return String.format("This is the  CPU  %s  %d \n", getClass(), hashCode());
  }
}
