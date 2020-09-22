package tk.exdeath.view.servlets.days;

import tk.exdeath.view.writers.TimetableWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(urlPatterns = "/days")
public class DaysServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String dayOfWeek = req.getParameter("dayOfWeek");

        if (dayOfWeek.equals("today")) {
            dayOfWeek = LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE"));
        }
        if (dayOfWeek.equals("tomorrow")) {
            dayOfWeek = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("EEEE"));
        }

        TimetableWriter.write(dayOfWeek, resp);
    }
}