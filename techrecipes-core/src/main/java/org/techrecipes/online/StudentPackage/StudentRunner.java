package org.techrecipes.online.StudentPackage;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.junit.Assert;
/**
 * Created by sjayapal on 9/25/2017.
 */
public class StudentRunner {
    public static void main(String args[]) {
        List<Student> studentList = new ArrayList<>();
        Student one = new Student();
        Student two= new Student();
        Student three= new Student();
        one.setName("John");
        Letters johnLetter1 = new Letters();
        johnLetter1.setLetterName("Kudos");
        Letters janeLetter = new Letters();
        janeLetter.setLetterName("Jane Kudos");
        Letters otherJaneLetter = new Letters();
        otherJaneLetter.setLetterName("Other Jane letter");
        one.setLettersSet(new HashSet<Letters>() {{
            add(johnLetter1);
            add(janeLetter);
            add(otherJaneLetter);
        }});
        two.setLettersSet(new HashSet<Letters>(){{
            add(johnLetter1);
            add(janeLetter);
        }});
        LetterRange johnLetter1Range = new LetterRange();
        johnLetter1Range.setLetterStartDate(new Date());
        johnLetter1Range.setLetterEndDate(new Date());
        LetterRange johnLetter2Range = new LetterRange();
        johnLetter1Range.setLetterStartDate(DateTime.now().plus(10).toDate());
        johnLetter1Range.setLetterEndDate(DateTime.now().plus(10).toDate());
        johnLetter1.setLetterRangeSet(new HashSet<LetterRange>() {{
            add(johnLetter1Range);
            add(johnLetter2Range);
        }});
        studentList.add(one);
        Set dataSet = studentList.stream().flatMap(student -> student.getLettersSet().stream())
                .collect(Collectors.toSet());
       Letters dataMap= studentList.stream().flatMap(student -> student.getLettersSet().stream()).filter(letters -> StringUtils.contains(letters.getLetterName(),"Jane")).findAny().orElseThrow(
            NoSuchElementException::new);
        System.out.println(dataMap);
        System.out.println(studentList.stream().flatMap(student -> student.getLettersSet().stream()).filter(letters -> StringUtils.contains(letters.getLetterName(),"Jane")).collect(Collectors.toSet()));
        Assert.assertTrue(dataSet.size() == 1);
    }
}
