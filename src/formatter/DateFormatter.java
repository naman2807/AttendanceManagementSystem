package formatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created By: Naman Agarwal
 * User ID: naman2807
 * Package Name: formatter
 * Project Name: AttendanceManagementSystem
 * Date: 08-06-2021
 */

public class DateFormatter {
    private DateFormatter() {
    }

    public static String getCurrentFormattedDate() {
        return DateTimeFormatter.ofPattern("dd MMMM, yyyy").format(LocalDate.now());
    }
}
