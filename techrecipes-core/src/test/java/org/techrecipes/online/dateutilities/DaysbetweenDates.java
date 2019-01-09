package org.techrecipes.online.dateutilities;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

/**
 * Created by sjayapal on 1/11/2017.
 */
public class DaysbetweenDates {
    final static Logger logger = LoggerFactory.getLogger(DaysbetweenDates.class);
    int currentYear = LocalDate.now().getYear();
    LocalDate firstQuarterStartDate = LocalDate.of(currentYear - 1, 7, 1);
    LocalDate firstQuarterEndDate = LocalDate.of(currentYear - 1, 10, 1);
    LocalDate secondQuarterStartDate = LocalDate.of(currentYear - 1, 10, 1);
    LocalDate secondQuarterEndDate = LocalDate.of(currentYear, 1, 1);
    LocalDate thirdQuarterStartDate = LocalDate.of(currentYear, 1, 1);
    LocalDate thirdQuarterEndDate = LocalDate.of(currentYear, 4, 1);
    LocalDate fourthQuarterStartDate = LocalDate.of(currentYear, 4, 1);
    LocalDate fourthQuarterEndDate = LocalDate.of(currentYear, 7, 1);

    @Test
    public void days_between_twodates() {
        DateTime startDate = new DateTime().minusDays(1);
        DateTime endDate = new DateTime();
        Days day_s = Days.daysBetween(startDate, endDate);
        int days = day_s.getDays();
        Assert.assertEquals(1, days);
    }

    @Test
    public void checkDateForQuarter() {
        LocalDate randomTwoYearDate = LocalDate.of(LocalDate.now().getYear() - 1, 7, 2);
        logger.info("The randomQuarter is " + randomTwoYearDate);
        Integer dateQuarter = randomTwoYearDate.query(new Quarter());
        Assert.assertNotNull(dateQuarter);
        logger.info("The dateQuarter is " + new Quarter());
    }

    private class Quarter implements TemporalQuery<Integer> {
        @Override
        public Integer queryFrom(TemporalAccessor temporalAccessor) {
            int inputMonth = temporalAccessor.get(ChronoField.MONTH_OF_YEAR);
            int inputYear = temporalAccessor.get(ChronoField.YEAR);
            int inputDay = temporalAccessor.get(ChronoField.DAY_OF_MONTH);
            LocalDate inputDate = LocalDate.of(inputYear, inputMonth, inputDay);
            if (inputDate.isEqual(firstQuarterStartDate)
                    || inputDate.isAfter(firstQuarterStartDate) && inputDate
                    .isBefore(firstQuarterEndDate)) {
                return 1;
            } else if (inputDate.isEqual(secondQuarterStartDate)
                    || inputDate.isAfter(secondQuarterStartDate) && inputDate
                    .isBefore(secondQuarterEndDate)) {
                return 2;
            } else if (inputDate.isEqual(thirdQuarterStartDate)
                    || inputDate.isAfter(thirdQuarterStartDate) && inputDate
                    .isBefore(thirdQuarterEndDate)) {
                return 3;
            } else if (inputDate.isEqual(fourthQuarterStartDate)
                    || inputDate.isAfter(fourthQuarterStartDate) && inputDate
                    .isBefore(fourthQuarterEndDate)) {
                return 4;
            }
            return null;
        }
    }
}
