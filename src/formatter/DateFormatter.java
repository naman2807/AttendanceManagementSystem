package formatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: formatter
 * Project Name: AttendanceManagementSystem
 * Date: 08-06-2021
 */

public class DateFormatter {
    private DateFormatter(){}

    public static String getCurrentFormattedDate(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd, MMMM yyyy");
        return dateFormatter.format(date);
    }
}
