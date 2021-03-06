package formatter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: formatter
 * Project Name: AttendanceManagementSystem
 * Date: 01-07-2021
 */

public class TimeFormatter {

    public static boolean validateTime(){
        LocalTime time = LocalTime.now();
        return time.isAfter(LocalTime.of(10,30))
                || time.isBefore(LocalTime.of(8,00));
    }

    public static String getCurrentTime(){
        LocalTime time = LocalTime.now();
        return time.format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}
