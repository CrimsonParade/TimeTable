package tk.exdeath.controller;

public class LessonsBeforeSummer extends NumberOfLessons {

    @Override
    long daysBeforeHolidays() {
        return ConstantPull.DAYS_BEFORE_SUMMER;
    }

    @Override
    public String getHolidaysName() {
        return "летних";
    }
}