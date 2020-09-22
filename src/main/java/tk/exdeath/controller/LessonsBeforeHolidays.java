package tk.exdeath.controller;

public class LessonsBeforeHolidays extends NumberOfLessons {

    @Override
    long daysBeforeHolidays() {
        return ConstantPull.DAYS_BEFORE_HOLIDAYS;
    }

    @Override
    public String getHolidaysName() {
        return "ближайших";
    }
}