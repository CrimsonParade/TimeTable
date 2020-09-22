package tk.exdeath.view.writers.numberOfLessons;

import tk.exdeath.controller.LessonsBeforeHolidays;
import tk.exdeath.controller.NumberOfLessons;

public class LessonsBeforeHolidaysWriter extends NumberOfLessonsWriter {

    @Override
    NumberOfLessons beforeWhatHolidays() {
        return new LessonsBeforeHolidays();
    }
}