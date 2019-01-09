package org.techrecipes.online.StudentPackage;
import java.util.Set;
/**
 * Created by sjayapal on 9/25/2017.
 */
public class Letters {
    private String letterName;
    private Set<LetterRange> letterRangeSet;
    public String getLetterName() {
        return letterName;
    }
    public void setLetterName(String letterName) {
        this.letterName = letterName;
    }
    public Set<LetterRange> getLetterRangeSet() {
        return letterRangeSet;
    }
    public void setLetterRangeSet(Set<LetterRange> letterRangeSet) {
        this.letterRangeSet = letterRangeSet;
    }
    @Override
    public String toString() {
        return "Letters{" +
            "letterName='" + letterName + '\'' +
            ", letterRangeSet=" + letterRangeSet +
            '}';
    }
}
