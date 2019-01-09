package org.techrecipes.online.lamma;

import io.lamma.*;
import net.steppschuh.markdowngenerator.table.Table;
import net.steppschuh.markdowngenerator.text.heading.Heading;
import org.springframework.stereotype.Component;

import java.time.Month;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component("calculateDateService")
public class CalculateDateService {

    public int OLD_RATE = 78;
    public int REVISED_RATE = 82;

    public static final int springNumberOfDays = 5;
    public static final int regularDaysOff = 5;
    public static final int winterNumberOfDays = 5;
    public static final int summerNumberOfDays = 5;

    public static final int DAILY_WORK_HOUR = 8;

    public static final String PLANNED_HOURS = "Planned hours";
    public static final String ACTUAL_HOURS = "Actual hours";
    public static final String NEWLINE = "\n";
    public static final String DESCRIPTION = "Description";

    public static final String PAID = "Paid";

    public static final String HOURS_TABLE_HEADER = "Hours data";
    public static final String HOURS = "Hours";
    public static final String NEW_BILLING_HEADER = "Revised payment";
    public static final String OLD_BILLING_HEADER = "Actual payment";

    public static final String PLANNED_MONEY = "Planned money";
    public static final String ACTUAL_MONEY = "Actual money";
    public static final String DIFF = "Difference money";

    int CONTRACT_FINISH_YEAR = 2019;
    int CONTRACT_START_YEAR = 2018;
    int CONTRACT_START_MONTH = 7;
    int CONTRACT_START_DAY = 1;
    int CONTRACT_END_MONTH = 6;
    int CONTRACT_END_DATE = 30;


    public final HolidayRule usHolidays = HolidayRules.simpleRule(
            new Date(CONTRACT_FINISH_YEAR, 1, 1),
            new Date(CONTRACT_FINISH_YEAR, 1, 15),
            new Date(CONTRACT_FINISH_YEAR, 2, 19),
            new Date(CONTRACT_FINISH_YEAR, 4, 16),
            new Date(CONTRACT_FINISH_YEAR, 5, 28),
            new Date(CONTRACT_FINISH_YEAR, 7, 4),
            new Date(CONTRACT_FINISH_YEAR, 9, 3),
            new Date(CONTRACT_FINISH_YEAR, 10, 8),
            new Date(CONTRACT_FINISH_YEAR, 11, 12),
            new Date(CONTRACT_FINISH_YEAR, 12, 25),
            new Date(CONTRACT_START_YEAR, 1, 1),
            new Date(CONTRACT_START_YEAR, 1, 15),
            new Date(CONTRACT_START_YEAR, 2, 19),
            new Date(CONTRACT_START_YEAR, 4, 16),
            new Date(CONTRACT_START_YEAR, 5, 28),
            new Date(CONTRACT_START_YEAR, 7, 4),
            new Date(CONTRACT_START_YEAR, 9, 3),
            new Date(CONTRACT_START_YEAR, 10, 8),
            new Date(CONTRACT_START_YEAR, 11, 12),
            new Date(CONTRACT_START_YEAR, 12, 25)
    );

    HolidayRule summerHolidays = HolidayRules.simpleRule
            (Dates.from(new Date(CONTRACT_START_YEAR, Month.AUGUST.getValue(), 1))
                    .to(new Date(CONTRACT_START_YEAR, Month.AUGUST.getValue(), 31))
                    .except(HolidayRules.weekends().and(usHolidays))
                    .byDays(summerNumberOfDays).build()
                    .toArray(new Date[0]));

    HolidayRule winterHolidays = HolidayRules.simpleRule
            (Dates.from(new Date(CONTRACT_START_YEAR, Month.DECEMBER.getValue(), 1))
                    .to(new Date(CONTRACT_START_YEAR, Month.DECEMBER.getValue(), 31))
                    .except(HolidayRules.weekends().and(usHolidays))
                    .byDays(winterNumberOfDays).build()
                    .toArray(new Date[0]));

    HolidayRule springHolidays =
            HolidayRules.simpleRule(Dates.from(new Date(CONTRACT_FINISH_YEAR, Month.MARCH.getValue(), 1))
                    .to(new Date(CONTRACT_FINISH_YEAR, Month.MARCH.getValue(), 31))
                    .except(HolidayRules.weekends().and(usHolidays))
                    .byDays(springNumberOfDays).build()
                    .toArray(new Date[0]));

    HolidayRule regularHolidays =
            HolidayRules.simpleRule
                    (Dates.from(new Date(CONTRACT_FINISH_YEAR, Month.MAY.getValue(), 1))
                            .to(new Date(CONTRACT_FINISH_YEAR, Month.MAY.getValue(), 31))
                            .except(HolidayRules.weekends().and(usHolidays))
                            .byDays(regularDaysOff).build()
                            .toArray(new Date[0]));

    /**
     * Default method calculator
     */
    public void defaultAllHolidaysCalc() {

        AtomicInteger plannedCounter = new AtomicInteger(0);
        AtomicInteger actualCounter = new AtomicInteger(0);

        calculatePlannedData(plannedCounter);
        //Customize HolidayRule to be applied.

        HolidayRule appliedRules = HolidayRules.weekends().and(usHolidays).
                and(summerHolidays).and(winterHolidays).and(springHolidays)
                .and(regularHolidays);

        List<Date> allFilteredDates = Dates
                .from(CONTRACT_START_YEAR, CONTRACT_START_MONTH, CONTRACT_START_DAY)
                .to(CONTRACT_FINISH_YEAR, CONTRACT_END_MONTH, CONTRACT_END_DATE)
                .except(appliedRules).build();

        allFilteredDates.stream().map(date -> {
            actualCounter.addAndGet(DAILY_WORK_HOUR);
            return date.dd();
        }).collect(Collectors.toList());

        try {
            buildTable(plannedCounter, actualCounter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Calculates the amount based on actual 2000 hours of working. Includes the US Holidays.
     *
     * @param plannedCounter
     */
    private void calculatePlannedData(AtomicInteger plannedCounter) {

        List<Date> filteredDates = Dates
                .from(CONTRACT_START_YEAR,
                        CONTRACT_START_MONTH,
                        CONTRACT_START_DAY)
                .to(CONTRACT_FINISH_YEAR,
                        CONTRACT_END_MONTH,
                        CONTRACT_END_DATE)
                .except(HolidayRules.weekends().and(usHolidays))
                .build();

        filteredDates.stream().map(date -> {
            plannedCounter.addAndGet(DAILY_WORK_HOUR);
            return date.dd();
        }).collect(Collectors.toList());

    }

    /**
     * Build table composition data.
     *
     * @param plannedCounter
     * @param actualCounter
     * @throws Exception
     */
    public void buildTable(AtomicInteger plannedCounter,
                           AtomicInteger actualCounter) {

        //Heading for the Actual and planned hours information.
        StringBuilder hours = new StringBuilder()
                .append(new Heading(HOURS_TABLE_HEADER, 1)).append(NEWLINE);
        buildPlannedTime(plannedCounter, actualCounter, hours);

        //Heading for the New Billing information
        StringBuilder NewMoney = new StringBuilder()
                .append(new Heading(NEW_BILLING_HEADER, 1)).append(NEWLINE);
        buildMoneyDetails(plannedCounter, actualCounter, NewMoney,
                PLANNED_MONEY, REVISED_RATE, ACTUAL_MONEY, DIFF);

        //Heading for the Old billing information
        StringBuilder oldMoney = new StringBuilder()
                .append(new Heading(OLD_BILLING_HEADER, 1)).append(NEWLINE);
        buildMoneyDetails(plannedCounter, actualCounter, oldMoney,
                PLANNED_MONEY, OLD_RATE, ACTUAL_MONEY, DIFF);
    }

    /**
     * Markdown table to build Money details
     *
     * @param plannedCounter
     * @param actualCounter
     * @param oldMoney
     * @param descTable
     * @param money
     * @param col1Desc
     * @param col2Desc
     */
    private void buildMoneyDetails(AtomicInteger plannedCounter,
                                   AtomicInteger actualCounter,
                                   StringBuilder oldMoney,
                                   String descTable,
                                   int money,
                                   String col1Desc,
                                   String col2Desc) {
        Table.Builder oldMoneyTableBuilder = new Table.Builder()
                .withAlignments(Table.ALIGN_RIGHT, Table.ALIGN_RIGHT)
                .withRowLimit(4)
                .addRow(DESCRIPTION, PAID);
        oldMoneyTableBuilder.addRow(descTable, plannedCounter.get() * money);
        oldMoneyTableBuilder.addRow(col1Desc, actualCounter.get() * money);
        oldMoneyTableBuilder.addRow(col2Desc, (plannedCounter.get() * money - actualCounter.get() * money));
        System.out.println(oldMoney.toString());
        System.out.println(oldMoneyTableBuilder.build());
        System.out.println("\n");
    }

    /**
     * Markdown table to build Planned and Actual hours table.
     *
     * @param plannedCounter
     * @param actualCounter
     * @param hours
     */
    private void buildPlannedTime(AtomicInteger plannedCounter,
                                  AtomicInteger actualCounter,
                                  StringBuilder hours) {
        Table.Builder tableBuilder = new Table.Builder()
                .withAlignments(Table.ALIGN_RIGHT, Table.ALIGN_RIGHT)
                .withRowLimit(3)
                .addRow(DESCRIPTION, HOURS);
        tableBuilder.addRow(PLANNED_HOURS, plannedCounter.get());
        tableBuilder.addRow(ACTUAL_HOURS, actualCounter.get());
        System.out.println(hours.toString());
        System.out.println(tableBuilder.build());
        System.out.println(NEWLINE);
    }
}
