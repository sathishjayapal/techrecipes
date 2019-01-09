package org.techrecipes.online.streams;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component("streamsToListSample")

public class StreamstoListSample {

  @Getter
  @Setter
  List<Developer> developerList = new ArrayList<Developer>();

  void populate() {
    {
      Faker faker = new Faker();
      for (int i = 0; i < 10; i++) {
        developerList.add(new Developer(faker.name().fullName(), faker.app().name()));
      }
    }
  }

  class Developer {

    String name;
    String language;

    public Developer(String name, String language) {
      this.name = name;
      this.language = language;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getLanguage() {
      return language;
    }

    public void setLanguage(String language) {
      this.language = language;
    }

    @Override
    public String toString() {
      return "Developer{" +
          "name='" + name + '\'' +
          ", language='" + language + '\'' +
          '}';
    }
  }
}
