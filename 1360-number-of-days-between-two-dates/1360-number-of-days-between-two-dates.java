import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Solution {
    public int daysBetweenDates(String dateStr1, String dateStr2) {
        LocalDate date1 = LocalDate.parse(dateStr1);
        LocalDate date2 = LocalDate.parse(dateStr2);  
        int daysBetween = (int) ChronoUnit.DAYS.between(date1, date2);

        return Math.abs(daysBetween);
    }
}