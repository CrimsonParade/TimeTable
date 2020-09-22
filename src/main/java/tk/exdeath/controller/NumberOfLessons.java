package tk.exdeath.controller;

import tk.exdeath.model.TimeTable;

import java.time.LocalDate;

public abstract class NumberOfLessons {

    private TimeTable lastLesson;
    private LocalDate lastLessonDate = LocalDate.MIN;

    private int addCounterValue(LocalDate dateNow, int counterValue) {

        if (dateNow.equals(ConstantPull.OCTOBER_HOLIDAYS) || dateNow.equals(ConstantPull.APRIL_HOLIDAYS)) {
            counterValue += ConstantPull.SHORT_HOLIDAYS_LENGTH;
        }
        if (dateNow.equals(ConstantPull.NOVEMBER_HOLIDAYS) || dateNow.equals(ConstantPull.FEBRUARY_HOLIDAYS)) {
            counterValue += ConstantPull.LONG_HOLIDAYS_LENGTH;
        }
        if (dateNow.equals(ConstantPull.NEW_YEAR_HOLIDAYS)) {
            counterValue += ConstantPull.NEW_YEAR_HOLIDAYS_LENGTH;
        }

        counterValue++;

        return counterValue;
    }

    private LocalDate addDays(LocalDate dateNow) {

        if (dateNow.equals(ConstantPull.OCTOBER_HOLIDAYS) || dateNow.equals(ConstantPull.APRIL_HOLIDAYS)) {
            dateNow = dateNow.plusDays(ConstantPull.SHORT_HOLIDAYS_LENGTH);
        }
        if (dateNow.equals(ConstantPull.NOVEMBER_HOLIDAYS) || dateNow.equals(ConstantPull.FEBRUARY_HOLIDAYS)) {
            dateNow = dateNow.plusDays(ConstantPull.LONG_HOLIDAYS_LENGTH);
        }
        if (dateNow.equals(ConstantPull.NEW_YEAR_HOLIDAYS)) {
            dateNow = dateNow.plusDays(ConstantPull.NEW_YEAR_HOLIDAYS_LENGTH);
        }

        dateNow = dateNow.plusDays(1);

        return dateNow;
    }

    public int lessonsBeforeSummer(String lessonName) {
        LocalDate dateNow = ConstantPull.DATE_NOW.minusDays(1);
        int numberOfLessons = 0;
        long daysBeforeHolidays = daysBeforeHolidays();

        for (int i = -1; i <= daysBeforeHolidays; ) {

            if (i == -1) {
                i = addCounterValue(dateNow, i);
                dateNow = addDays(dateNow);
            }

            for (TimeTable timeTable : ConstantPull.READER.readByDayOfWeek(dateNow.format(ConstantPull.DAY_OF_WEEK))) {
                if (timeTable.getLessonName().equals(lessonName)) {
                    lastLesson = timeTable;
                    lastLessonDate = dateNow;
                    numberOfLessons++;
                }
            }
            i = addCounterValue(dateNow, i);
            dateNow = addDays(dateNow);
        }

        return numberOfLessons;
    }

    public LocalDate getLastLessonDate() {
        return lastLessonDate;
    }

    public TimeTable getLastLesson() {
        return lastLesson;
    }

    abstract long daysBeforeHolidays();

    public abstract String getHolidaysName();
}