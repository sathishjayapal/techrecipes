package org.techrecipes.online.springwiring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Book {
  private String bookName;
  @Autowired
  private Author author;
  @Autowired
  private Category category;
  public String getBookName() {
    return bookName;
  }
  public void setBookName(String bookName) {
    this.bookName = bookName;
  }
  public Author getAuthor() {
    return author;
  }
  public void setAuthor(Author author) {
    this.author = author;
  }
  public Category getCategory() {
    return category;
  }
  public void setCategory(Category category) {
    this.category = category;
  }
  @Override
  public String toString() {
    return "Book{" +
        "bookName='" + bookName + '\'' +
        ", author=" + author +
        ", category=" + category +
        '}';
  }
}
