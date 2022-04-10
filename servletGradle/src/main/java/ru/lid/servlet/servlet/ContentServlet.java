package ru.lid.servlet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.lid.servlet.dto.FlightDto;
import ru.lid.servlet.service.FlightService;
import ru.lid.servlet.util.JspHelper;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/content")
public class ContentServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FlightDto> flightDtos = flightService.findAll();


        req.setAttribute("flights", flightDtos);
        req.setAttribute("flightsMap", flightDtos.stream()
                .collect(Collectors.toMap(FlightDto::getId, FlightDto::getDescription)));
        req.getRequestDispatcher(JspHelper.getPath("content"))
                .forward(req, resp);
    }
}
