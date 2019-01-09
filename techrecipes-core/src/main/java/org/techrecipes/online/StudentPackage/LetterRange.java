package org.techrecipes.online.StudentPackage;
import java.util.Date;
/**
 * Created by sjayapal on 9/25/2017.
 */
public class LetterRange {
    private Date letterStartDate;
    private Date letterEndDate;
    public Date getLetterStartDate() {
        return letterStartDate;
    }
    public void setLetterStartDate(Date letterStartDate) {
        this.letterStartDate = letterStartDate;
    }
    public Date getLetterEndDate() {
        return letterEndDate;
    }
    public void setLetterEndDate(Date letterEndDate) {
        this.letterEndDate = letterEndDate;
    }
    @Override
    public String toString() {
        return "LetterRange{" +
            "letterStartDate=" + letterStartDate +
            ", letterEndDate=" + letterEndDate +
            '}';
    }
}
