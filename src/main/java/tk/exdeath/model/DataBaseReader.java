package tk.exdeath.model;

import tk.exdeath.model.hibernate.DAO;

import java.util.List;

public class DataBaseReader {

    private final DAO DAO = new DAO();

    public DataBaseReader() {
    }

    public List<TimeTable> readByDayOfWeek(String dayOfWeek) {
        return DAO.readByDayOfWeek(dayOfWeek);
    }

    public List<String> readAllLessons() {
        return DAO.readAllLessons();
    }
}