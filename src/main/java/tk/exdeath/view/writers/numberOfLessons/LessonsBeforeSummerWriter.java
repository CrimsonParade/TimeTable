package tk.exdeath.view.writers.numberOfLessons;

import tk.exdeath.controller.LessonsBeforeSummer;
import tk.exdeath.controller.NumberOfLessons;

public class LessonsBeforeSummerWriter extends NumberOfLessonsWriter {

    @Override
    NumberOfLessons beforeWhatHolidays() {
        return new LessonsBeforeSummer();
    }
}