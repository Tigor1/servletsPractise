package ru.lid.servlet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.lid.servlet.service.FlightService;
import ru.lid.servlet.util.JspHelper;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/flights")
public class FlightServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("flights", flightService.findAll());

        req.getRequestDispatcher(JspHelper.getPath("flights"))
                        .forward(req, resp);

//        заменим динамический ответ html на jsp
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//
//        try (var writer = resp.getWriter()) {
//            writer.write("<h1>Список перелетов</h1>");
//            writer.write("<ul>");
//
//            flightService.findAll().forEach(flightDto -> {
//                writer.write("""
//                        <li>
//                           <a href="/lid/tickets?flightId=%d">%s</a>
//                        </li>
//                        """.formatted(flightDto.getId(), flightDto.getDescription()));
//            });
//            writer.write("");
//            writer.write("</ul>");
//        }
    }
}
