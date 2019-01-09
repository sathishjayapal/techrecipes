package org.techrecipes.online.abstract_factory;
public abstract class Memory {
  @Override
  public String toString() {
    return String.format("This is the  memory %s %d \n", getClass(), hashCode());
  }
}
