package org.techrecipes.online.StudentPackage;
import java.util.Set;
/**
 * Created by sjayapal on 9/25/2017.
 */
public class Student {
    Set<Letters> lettersSet;
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<Letters> getLettersSet() {
        return lettersSet;
    }
    public void setLettersSet(Set<Letters> lettersSet) {
        this.lettersSet = lettersSet;
    }
    @Override
    public String toString() {
        return "Student{" +
            "lettersSet=" + lettersSet +
            ", name='" + name + '\'' +
            '}';
    }
}
