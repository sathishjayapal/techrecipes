package org.techrecipes.online.springwiring;
import org.springframework.stereotype.Component;
@Component
public class Category {
  private String categoryName;
  public String getCategoryName() {
    return categoryName;
  }
  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }
  @Override
  public String toString() {
    return "Category{" +
        "categoryName='" + categoryName + '\'' +
        '}';
  }
}
