package tk.exdeath.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "timetable")
public class TimeTable {

    @Id
    private int id;
    private int lessonNumber;
    private String dayOfWeek;
    private String lessonName;
    private String roomNumber;
    private String teacherName;

    public TimeTable() {
    }

    @Override
    public String toString() {
        return "\nДень недели: " + dayOfWeek +
                " | Урок номер: " + lessonNumber +
                " | Кабинет: " + roomNumber +
                " | Урок: " + lessonName +
                " | Учитель: " + teacherName;
    }

    public String toHTML() {
        return "<pre>День недели: " + dayOfWeek +
                " | Урок номер: " + lessonNumber +
                " | Кабинет: " + roomNumber +
                " | Урок: " + lessonName +
                " | Учитель: " + teacherName + "<br></pre>";
    }

    public String getLessonName() {
        return lessonName;
    }

}
