package tk.exdeath.view.servlets.lessons;

import tk.exdeath.view.writers.numberOfLessons.LessonsBeforeHolidaysWriter;
import tk.exdeath.view.writers.numberOfLessons.LessonsBeforeSummerWriter;
import tk.exdeath.view.writers.numberOfLessons.NumberOfLessonsWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/lessons")
public class LessonsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        NumberOfLessonsWriter writer = new LessonsBeforeHolidaysWriter();
        resp.setContentType("text/html; charset=UTF-8");
        String lessonName = req.getParameter("lessonName");

        writer.write(lessonName, resp);
        resp.getWriter().println(NumberOfLessonsWriter.DELIMITER);

        writer = new LessonsBeforeSummerWriter();
        writer.write(lessonName, resp);
    }
}
