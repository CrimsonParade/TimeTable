package tk.exdeath.view.servlets.lessons;

import tk.exdeath.model.DataBaseReader;
import tk.exdeath.view.writers.numberOfLessons.LessonsBeforeHolidaysWriter;
import tk.exdeath.view.writers.numberOfLessons.LessonsBeforeSummerWriter;
import tk.exdeath.view.writers.numberOfLessons.NumberOfLessonsWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/every")
public class EveryServlet extends HttpServlet {

    static final DataBaseReader reader = new DataBaseReader();
    static NumberOfLessonsWriter writer;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");

        if (req.getParameter("before").equals("nearest")) {
            writer = new LessonsBeforeHolidaysWriter();
        }
        if (req.getParameter("before").equals("summer")) {
            writer = new LessonsBeforeSummerWriter();
        }

        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        for (String certainLesson : reader.readAllLessons()) {
            writer.write(certainLesson, resp);
            resp.getWriter().print(NumberOfLessonsWriter.DELIMITER);
        }
    }
}