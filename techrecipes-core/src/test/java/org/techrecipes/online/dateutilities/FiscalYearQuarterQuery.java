package org.techrecipes.online.dateutilities;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
public class FiscalYearQuarterQuery implements TemporalQuery<Integer> {
    @Override
    public Integer queryFrom(TemporalAccessor date) {
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        if (month < Month.APRIL.getValue()) {
            return 3;
        } else if (month < Month.JULY.getValue()) {
            return 4;
        } else if (month < Month.OCTOBER.getValue()) {
            return 1;
        } else {
            return 2;
        }
    }
    @Test
    public void checkQuarterOfFiling() {
        LocalDate localDate = LocalDate.of(2014, Month.MARCH, 4);
        Integer quarter = localDate.query(new FiscalYearQuarterQuery());
        Assert.assertEquals(quarter, Integer.valueOf(3));
    }
}
