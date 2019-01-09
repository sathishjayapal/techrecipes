package org.techrecipes.online.constructors;

public class Student {

  private final String name;
  private final Boolean isAdvanced;
  private String tier1;
  private String tier2;

  public static class Builder {

    private final String name;
    private final Boolean isAdvanced;
    private  String tier1;
    private String tier2;

    public Builder(String name, Boolean isAdvanced) {
      this.isAdvanced = isAdvanced;
      this.name = name;
    }

    public Student build() {
      return new Student(this);
    }

    public Builder tier1Val(String tier1Val) {
      tier1 = tier1Val;
      return this;
    }
    public Builder tier2Val(String tier2Val) {
      tier2 = tier2Val;
      return this;
    }
  }

  private Student(Builder builder) {
    name = builder.name;
    isAdvanced = builder.isAdvanced;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Student{");
    sb.append("name='").append(name).append('\'');
    sb.append(", isAdvanced=").append(isAdvanced);
    sb.append(", tier1='").append(tier1).append('\'');
    sb.append(", tier2='").append(tier2).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
