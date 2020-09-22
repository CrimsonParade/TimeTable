package tk.exdeath.view.writers;

import tk.exdeath.model.DataBaseReader;
import tk.exdeath.model.TimeTable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class TimetableWriter {

    private static final DataBaseReader READER = new DataBaseReader();

    public static void write(String dayOfWeek, HttpServletResponse resp) throws IOException {

        if (isHoliday(dayOfWeek)) {
            resp.getWriter().println("Выходной!");
        } else {
            for (TimeTable timeTable : READER.readByDayOfWeek(dayOfWeek)) {
                resp.getWriter().println(timeTable.toHTML());
            }
        }
    }

    private static boolean isHoliday(String dayOfWeek) {
        return READER.readByDayOfWeek(dayOfWeek).isEmpty();
    }
}