package org.techrecipes.online.commons;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import java.util.Map;
import java.util.TreeMap;
public class TreeMapSample {
    public static void main(String args[]) {
        Kid kids[] = {new Kid(
                "Kid1",
                DateTime.parse("05/01/05", DateTimeFormat.forPattern("MM/dd/yy")).toLocalDate()),
                new Kid("Kid2", DateTime.parse("01/06/05", DateTimeFormat.forPattern("MM/dd/yy"))
                        .toLocalDate()),
                new Kid("Kid3", DateTime.parse("07/12/12", DateTimeFormat.forPattern("MM/dd/yy"))
                        .toLocalDate())};
        Map<LocalDate, String> sortedMap = new TreeMap<LocalDate, String>();
        for (Kid kid : kids) {
            sortedMap.put(kid.getDob(), kid.getName());
        }
        System.out.println(sortedMap.values());
    }
    static class Kid {
        private String name;
        private LocalDate dob;
        public Kid(String name, LocalDate dob) {
            this.name = name;
            this.dob = dob;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public LocalDate getDob() {
            return dob;
        }
        public void setDob(LocalDate dob) {
            this.dob = dob;
        }
    }
}
