package tk.exdeath.model.hibernate;

import org.hibernate.Session;
import tk.exdeath.model.TimeTable;

import java.util.List;

public class DAO {

    public List<TimeTable> readByDayOfWeek(String dayOfWeek) {
        String hql = "FROM TimeTable where dayOfWeek = :paramName order by lessonNumber ASC ";

        return getSession().createQuery(hql).setParameter("paramName", dayOfWeek).list();
    }

    public List<String> readAllLessons() {
        String hql = "Select lessonName from TimeTable group by lessonName";

        return getSession().createQuery(hql).list();
    }

    private Session getSession() {
        return HibernateFactory.getSessionFactory().openSession();
    }
}