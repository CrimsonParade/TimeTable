package tk.exdeath.view.writers.numberOfLessons;

import tk.exdeath.controller.NumberOfLessons;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class NumberOfLessonsWriter {

    private final NumberOfLessons COUNTER = beforeWhatHolidays();
    public static final String DELIMITER = "-------------------------------------------------------------------------";


    public void write(String lessonName, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("<pre>Предмет: " + lessonName + "<br>Количество уроков до " + holidaysName() + " каникул: " + lessonsBeforeSummer(lessonName) + "</pre>");
        if (isNotNull()) {
            resp.getWriter().print("<pre>Дата последнего урока: " + lastLessonDate() + "<br>Информация о нём: " + lastLesson() + "</pre>");
        }
    }

    private boolean isNotNull() {
        return !COUNTER.getLastLessonDate().equals(LocalDate.MIN);
    }

    private int lessonsBeforeSummer(String lessonName) {
        return COUNTER.lessonsBeforeSummer(lessonName);
    }

    private String lastLessonDate() {
        DateTimeFormatter dayMonthYear = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return COUNTER.getLastLessonDate().format(dayMonthYear);
    }

    private String lastLesson() {
        return COUNTER.getLastLesson().toHTML();
    }

    private String holidaysName() {
        return COUNTER.getHolidaysName();
    }

    abstract NumberOfLessons beforeWhatHolidays();
}